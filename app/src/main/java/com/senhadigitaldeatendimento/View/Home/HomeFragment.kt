package com.senhadigitaldeatendimento.View.Home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.UltimaSenha

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.CustomDialogSenha
import com.senhadigitaldeatendimento.View.Painel.PainelFragment
import kotlinx.android.synthetic.main.fragment_home.*

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

    companion object {
        fun newInstance(): HomeFragment {
            var fragmentHome = HomeFragment()
            var args = Bundle()
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

        button_transporte.setOnClickListener {
            gerarSenha(TRANSPORTE)
            showDialog("Sua senha é", this.senhaFrag!!)
        }
        button_reclamacoes.setOnClickListener {
            gerarSenha(RECLAMACOES)
            showDialog("Sua senha é", this.senhaFrag!!)
        }
        button_notasefaltas.setOnClickListener {
            gerarSenha(NOTAS_E_FALTAS)
            showDialog("Sua senha é", this.senhaFrag!!)
        }
        button_documentos.setOnClickListener {
            gerarSenha(DOCUMENTOS)
            showDialog("Sua senha é", this.senhaFrag!!)
        }
        button_assuntosgerais.setOnClickListener {
            gerarSenha(ASSUNTOS_GERAIS)
            showDialog("Sua senha é", this.senhaFrag!!)
        }

    }

    fun gerarSenha(topico:String){

        presenter.generatePass(topico)

    }

    override fun getLista(list: ArrayList<UltimaSenha>) {

        val intent = Intent(context, PainelFragment::class.java)
        intent.putExtra(INTENT_LISTA,list)

    }

    fun showDialog(tittle:String, body:String){

        CustomDialogSenha(this.context!!).showDialogPassword(tittle,body,
                object:CustomDialogSenha.onClickListenerPass{
                    override fun goToPassword() {

                    }

                    override fun closeDialog() {

                    }

                })

    }

    override fun showSenha(senha: String) {

        senhaFrag = senha

    }

}
