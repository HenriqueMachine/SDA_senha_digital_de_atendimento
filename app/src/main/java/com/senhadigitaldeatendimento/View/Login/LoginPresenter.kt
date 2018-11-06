package com.senhadigitaldeatendimento.View.Login

import android.content.Context
import com.senhadigitaldeatendimento.View.Register.RegisterContract

class LoginPresenter(var context: Context?,
                     override var view : LoginContract.UserView?) :
        LoginContract.UserActionsListener<LoginContract.UserView> {



}