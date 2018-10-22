package com.senhadigitaldeatendimento.View.HistoricoSenhas

import android.content.Context

class HistoricoSenhasPresenter (var context: Context?,
                               override var view: HistoricoSenhasContract.UserView?) :
        HistoricoSenhasContract.UserActionsListener<HistoricoSenhasContract.UserView> {
}