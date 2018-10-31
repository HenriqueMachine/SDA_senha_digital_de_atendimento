package com.senhadigitaldeatendimento.View.Home

import com.senhadigitaldeatendimento.Model.Senhas
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HomeContract {

    //Retornando Dado::::::::

    interface UserView: View {

        fun getLista(list:ArrayList<Senhas>)
        fun showSenha(senha:String)

    }

    //Enviando dado::::::::

    interface UserActionsListener < T : View> : Presenter<T> {

        fun generatePass(tipoSenha: String)

    }

}