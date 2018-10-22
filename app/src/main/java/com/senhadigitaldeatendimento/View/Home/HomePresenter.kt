package com.senhadigitaldeatendimento.View.Home

import android.content.Context
import com.senhadigitaldeatendimento.View.Painel.PainelContract

class HomePresenter (var context: Context?,
                     override var view: HomeContract.UserView?) :
        HomeContract.UserActionsListener<HomeContract.UserView> {
}