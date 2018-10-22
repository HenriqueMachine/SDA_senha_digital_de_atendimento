package com.senhadigitaldeatendimento.View.Painel

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class PainelPresenter (var context: Context?,
                       override var view: PainelContract.UserView?) :
        PainelContract.UserActionsListener<PainelContract.UserView> {

    override fun lastPasswords() {

        val list = GetSenhas.getSenhas(context)

        view?.setList(list)
    }


}