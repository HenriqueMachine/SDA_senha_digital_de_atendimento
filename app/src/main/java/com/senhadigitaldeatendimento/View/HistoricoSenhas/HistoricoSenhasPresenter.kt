package com.senhadigitaldeatendimento.View.HistoricoSenhas

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class HistoricoSenhasPresenter (var context: Context?,
                               override var view: HistoricoSenhasContract.UserView?) :
        HistoricoSenhasContract.UserActionsListener<HistoricoSenhasContract.UserView> {
    override fun historicoSet() {

        val list = GetSenhas.getSenhas(context)

        view?.obterHistorico(list)

    }
}