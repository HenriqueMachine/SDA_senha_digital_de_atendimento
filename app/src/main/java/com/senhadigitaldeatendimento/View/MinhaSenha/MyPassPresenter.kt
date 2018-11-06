package com.senhadigitaldeatendimento.View.MinhaSenha

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class MyPassPresenter(var context: Context?,
                      override var view: MyPassContract.UserView?) :
        MyPassContract.UserActionsListener<MyPassContract.UserView> {

    override fun getMinhaSenha() {

        val list = GetSenhas.getMyPass(context)

        if (list.isNotEmpty()){

            val minhaUltimaSenhaNumero = list[list.size - 1].numeroSenha
            val minhaUltimaSenhaCategoria = list[list.size - 1].categoria
            val minhaUltimaSenhaHora = list[list.size - 1].hour

            view?.obterMinhaSenha(minhaUltimaSenhaNumero,
                    minhaUltimaSenhaCategoria,
                    minhaUltimaSenhaHora)

        }





    }
}