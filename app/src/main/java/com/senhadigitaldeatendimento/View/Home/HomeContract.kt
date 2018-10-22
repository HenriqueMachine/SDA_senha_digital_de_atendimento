package com.senhadigitaldeatendimento.View.Home

import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HomeContract {

    interface UserView: View {


    }

    interface UserActionsListener < T : View> : Presenter<T> {

    }

}