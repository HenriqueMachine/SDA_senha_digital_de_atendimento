package com.senhadigitaldeatendimento.View.Register

import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface RegisterContract {

    interface UserView: View {


    }

    interface UserActionsListener < T : View> : Presenter<T> {


    }

}