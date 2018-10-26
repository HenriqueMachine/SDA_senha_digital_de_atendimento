package com.senhadigitaldeatendimento.View.Painel

import android.content.Context
import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class PainelPresenter (var context: Context?,
                       override var view: PainelContract.UserView?) :
        PainelContract.UserActionsListener<PainelContract.UserView> {
    override fun getLastSenha() {

        val list = GetSenhas.getSenhas(context)

        if(list.isNotEmpty()){

            val senhaUltima = "${list.last().topico} ${list.last().numeroSenha}"

            view?.lastSenha(senhaUltima)

        }
    }

    override fun lastPasswords() {

        val list = GetSenhas.getSenhas(context)

        view?.setList(list.reversed() as ArrayList<UltimaSenha>)
    }


}