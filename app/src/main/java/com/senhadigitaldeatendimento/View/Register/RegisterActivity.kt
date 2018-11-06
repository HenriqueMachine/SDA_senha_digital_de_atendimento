package com.senhadigitaldeatendimento.View.Register

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.getColor
import android.util.AttributeSet
import android.util.Log
import android.view.View
import br.com.ipiranga.profrotas.Support.Util.MaskEditUtil
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.CustomDialogSenha
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.UserView {

    private val presenter : RegisterContract.UserActionsListener<RegisterContract.UserView> by lazy {
        RegisterPresenter(this@RegisterActivity, this)
    }

    private var nomeUser:String? = null
    private var cpfUser:String? = null
    private var emailUser:String? = null
    private var telefoneUser:String? = null
    private var dataUser:String? = null

    private var pass1:String? = null
    private var pass2:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()

    }

    private fun initView() {


        data_nascimento.addTextChangedListener(MaskEditUtil.mask(data_nascimento,MaskEditUtil.FORMAT_DATE))

        cpf.addTextChangedListener(MaskEditUtil.mask(cpf,MaskEditUtil.FORMAT_CPF))

        numero_telefone.addTextChangedListener(MaskEditUtil.mask(numero_telefone,MaskEditUtil.FORMAT_FONE))

        button_cadastrar.setOnClickListener {

            nomeUser = nome.text.toString()

            emailUser = email.text.toString()

            cpfUser = cpf.addTextChangedListener(MaskEditUtil.mask(cpf,MaskEditUtil.FORMAT_CPF)).toString()

            telefoneUser = numero_telefone.addTextChangedListener(MaskEditUtil.mask(numero_telefone,MaskEditUtil.FORMAT_FONE)).toString()

            dataUser = data_nascimento.addTextChangedListener(MaskEditUtil.mask(data_nascimento,MaskEditUtil.FORMAT_DATE)).toString()

            pass1 = password.editText?.text.toString()

            pass2 = password_confirm.editText?.text.toString()

            if (password_confirm.editText?.text.toString() != password.editText?.text.toString() ) {

                CustomDialogSenha(this@RegisterActivity).showDialogDefaultError("Atenção",
                        "Verifique os dados preenchidos e tente novamente",
                        object : CustomDialogSenha.onClickListenerError{
                            override fun ok() {

                            }

                        })

            }



        }

    }


}
