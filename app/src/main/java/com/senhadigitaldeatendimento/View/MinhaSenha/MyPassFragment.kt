package com.senhadigitaldeatendimento.View.MinhaSenha


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.CustomDialogSenha
import kotlinx.android.synthetic.main.fragment_minhasenha.*

class MyPassFragment : Fragment(), MyPassContract.UserView {

    private val presenter : MyPassContract.UserActionsListener<MyPassContract.UserView> by lazy {
        MyPassPresenter(activity,this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_minhasenha, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.getMinhaSenha()

        button_cancelar_senha.setOnClickListener {

            CustomDialogSenha(this.context!!).showDialogDefault("Atenção",
                    "Deseja cancelar está senha?\nEste processo não pode ser desfeito.",
                    object : CustomDialogSenha.onClickListenerDefault{
                        override fun yes() {

                            textview_desc_mypass?.text = ""
                            textview_desc_categoria_mypass?.text = ""
                            textview_desc_horario_mypass?.text = ""

                        }

                        override fun no() {


                        }

                    })

        }

    }

    override fun obterMinhaSenha(senha: String, categoria: String, hora: String) {

        textview_desc_mypass?.text = hora
        textview_desc_categoria_mypass?.text = categoria
        textview_desc_horario_mypass?.text = senha


    }


}
