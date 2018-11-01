package com.senhadigitaldeatendimento.View.MinhaSenha

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class MyPassPresenter(var context: Context?,
                      override var view: MyPassContract.UserView?) :
        MyPassContract.UserActionsListener<MyPassContract.UserView> {

    override fun getMyPass() {



    }
}