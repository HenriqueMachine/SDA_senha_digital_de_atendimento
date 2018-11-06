package com.senhadigitaldeatendimento.View.Register

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetUser

class RegisterPresenter (var context: Context?,
                         override var view : RegisterContract.UserView?) :
        RegisterContract.UserActionsListener<RegisterContract.UserView> {

    override fun saveUser(nome: String, cpf: String, dataNascimento: String, telefone: String, email: String) {

        GetUser.saveInfo(context,nome,cpf,dataNascimento,telefone,email)

    }

}