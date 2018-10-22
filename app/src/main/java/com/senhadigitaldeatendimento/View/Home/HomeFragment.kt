package com.senhadigitaldeatendimento.View.Home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.UltimaSenha

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.View.Painel.PainelFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.UserView {

    private val presenter : HomeContract.UserActionsListener<HomeContract.UserView> by lazy {
        HomePresenter(activity, this)
    }

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

        button_transporte.setOnClickListener { gerarSenha(TRANSPORTE) }
        button_reclamacoes.setOnClickListener { gerarSenha(RECLAMACOES) }
        button_notasefaltas.setOnClickListener { gerarSenha(NOTAS_E_FALTAS) }
        button_documentos.setOnClickListener { gerarSenha(DOCUMENTOS) }
        button_assuntosgerais.setOnClickListener { gerarSenha(ASSUNTOS_GERAIS) }

    }

    fun gerarSenha(topico:String){

        presenter.generatePass(topico)

    }

    override fun showSenha(senha:String) {


    }

    override fun getLista(list: ArrayList<UltimaSenha>) {

        val intent = Intent(context, PainelFragment::class.java)
        intent.putExtra(INTENT_LISTA,list)

    }

}
