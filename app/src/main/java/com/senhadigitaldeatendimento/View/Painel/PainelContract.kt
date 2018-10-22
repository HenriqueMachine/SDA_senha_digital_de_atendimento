package com.senhadigitaldeatendimento.View.Painel

import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface PainelContract {

    interface UserView: View {


    }

    interface UserActionsListener < T : View> : Presenter<T> {

    }

}