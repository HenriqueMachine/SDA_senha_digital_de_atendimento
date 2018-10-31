package com.senhadigitaldeatendimento.View.Painel

import com.senhadigitaldeatendimento.Model.Senhas
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface PainelContract {

    interface UserView: View {

        fun setList(list:ArrayList<Senhas>)
        fun lastSenha(ultimaSenha: String)

    }

    interface UserActionsListener < T : View> : Presenter<T> {

        fun lastPasswords()
        fun getLastSenha()

    }

}