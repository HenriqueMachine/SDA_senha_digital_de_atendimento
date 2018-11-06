package com.senhadigitaldeatendimento.View.Home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.Senhas

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.CustomDialogSenha
import com.senhadigitaldeatendimento.View.MainActivityBottomNav.BottomNavigationActivity
import com.senhadigitaldeatendimento.View.Painel.PainelFragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment(), HomeContract.UserView {


    private val presenter : HomeContract.UserActionsListener<HomeContract.UserView> by lazy {
        HomePresenter(activity, this)
    }

    private var senhaFrag:String? = null

    private val INTENT_LISTA = "INTENT_LIST"

    private val TRANSPORTE = "TR"
    private val RECLAMACOES= "RC"
    private val NOTAS_E_FALTAS = "NF"
    private val DOCUMENTOS= "DC"
    private val ASSUNTOS_GERAIS = "AG"

    private val TRANSPORTE_TEXT = "TRANSPORTE"
    private val RECLAMACOES_TEXT = "RECLAMAÇÕES"
    private val NOTAS_E_FALTAS_TEXT = "NOTAS E FALTAS"
    private val DOCUMENTOS_TEXT = "DOCUMENTOS"
    private val ASSUNTOS_GERAIS_TEXT = "ASSUNTOS GERAIS"

    companion object {
        fun newInstance(): HomeFragment {
            val fragmentHome = HomeFragment()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateFormat = SimpleDateFormat("HH:mm:ss")
        val hour =  dateFormat.format(Date())

        button_transporte.setOnClickListener {
            gerarSenha(TRANSPORTE)
            showDialog("Atenção", this.senhaFrag!!,TRANSPORTE_TEXT,hour)
            presenter.saveMyPass(TRANSPORTE_TEXT,hour, senhaFrag!!)
        }
        button_reclamacoes.setOnClickListener {
            gerarSenha(RECLAMACOES)
            showDialog("Atenção", this.senhaFrag!!,RECLAMACOES_TEXT,hour)
            presenter.saveMyPass(RECLAMACOES_TEXT,hour, senhaFrag!!)
        }
        button_notasefaltas.setOnClickListener {
            gerarSenha(NOTAS_E_FALTAS)
            showDialog("Atenção", this.senhaFrag!!,NOTAS_E_FALTAS_TEXT,hour)
            presenter.saveMyPass(NOTAS_E_FALTAS_TEXT,hour, senhaFrag!!)
        }
        button_documentos.setOnClickListener {
            gerarSenha(DOCUMENTOS)
            showDialog("Atenção", this.senhaFrag!!,DOCUMENTOS_TEXT,hour)
            presenter.saveMyPass(DOCUMENTOS_TEXT,hour, senhaFrag!!)
        }
        button_assuntosgerais.setOnClickListener {
            gerarSenha(ASSUNTOS_GERAIS)
            showDialog("Atenção", this.senhaFrag!!,ASSUNTOS_GERAIS_TEXT,hour)
            presenter.saveMyPass(ASSUNTOS_GERAIS_TEXT,hour, senhaFrag!!)
        }

    }

    fun gerarSenha(topico:String){

        presenter.generatePass(topico)

    }

    override fun getLista(list: ArrayList<Senhas>) {

        val intent = Intent(context, PainelFragment::class.java)
        intent.putExtra(INTENT_LISTA,list)

    }

    fun showDialog(tittle:String, body:String, category:String, hour:String){

        CustomDialogSenha(this.context!!).showDialogPassword(tittle,
                body,
                category,
                hour,

                object:CustomDialogSenha.onClickListenerPass{
                    override fun goToPassword() {

                        BottomNavigationActivity.minhaSenha = true

                    }

                    override fun closeDialog() {

                    }

                })

    }

    override fun showSenha(senha: String) {

        senhaFrag = senha

    }

}
