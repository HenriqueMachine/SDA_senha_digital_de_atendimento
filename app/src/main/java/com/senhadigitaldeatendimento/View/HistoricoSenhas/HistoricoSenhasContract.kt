package com.senhadigitaldeatendimento.View.HistoricoSenhas

import com.senhadigitaldeatendimento.Model.Senhas
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HistoricoSenhasContract {

    interface UserView: View {

        fun obterHistorico(list: ArrayList<Senhas>)

    }

    interface UserActionsListener < T : View> : Presenter<T> {

        fun historicoSet()

    }

}