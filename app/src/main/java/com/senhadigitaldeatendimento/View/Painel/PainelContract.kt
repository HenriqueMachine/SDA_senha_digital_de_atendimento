package com.senhadigitaldeatendimento.View.Painel

import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface PainelContract {

    interface UserView: View {

        fun setList(list:ArrayList<UltimaSenha>)

    }

    interface UserActionsListener < T : View> : Presenter<T> {

        fun lastPasswords()

    }

}