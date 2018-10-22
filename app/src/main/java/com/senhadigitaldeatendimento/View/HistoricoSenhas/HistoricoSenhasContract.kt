package com.senhadigitaldeatendimento.View.HistoricoSenhas

import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HistoricoSenhasContract {

    interface UserView: View {


    }

    interface UserActionsListener < T : View> : Presenter<T> {

    }

}