package com.senhadigitaldeatendimento.View.Painel

import android.content.Context

class PainelPresenter (var context: Context?,
                       override var view: PainelContract.UserView?) :
        PainelContract.UserActionsListener<PainelContract.UserView> {

}