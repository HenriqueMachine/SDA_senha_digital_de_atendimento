package com.senhadigitaldeatendimento.View.HistoricoSenhas

import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HistoricoSenhasContract {

    interface UserView: View {

        fun obterHistorico(list: ArrayList<UltimaSenha>)

    }

    interface UserActionsListener < T : View> : Presenter<T> {

        fun historicoSet()

    }

}