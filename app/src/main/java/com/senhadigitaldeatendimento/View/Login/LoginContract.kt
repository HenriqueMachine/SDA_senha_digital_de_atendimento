package com.senhadigitaldeatendimento.View.Login

import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface LoginContract {

    interface UserView: View {


    }

    interface UserActionsListener < T : View> : Presenter<T> {


    }

}