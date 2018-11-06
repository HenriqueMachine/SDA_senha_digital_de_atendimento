package com.senhadigitaldeatendimento.View.Register

import android.content.Context

class RegisterPresenter (var context: Context?,
                         override var view : RegisterContract.UserView?) :
        RegisterContract.UserActionsListener<RegisterContract.UserView> {



}