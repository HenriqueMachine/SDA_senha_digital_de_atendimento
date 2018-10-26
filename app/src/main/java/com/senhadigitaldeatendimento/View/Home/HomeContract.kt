package com.senhadigitaldeatendimento.View.Home

import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface HomeContract {

    //Retornando Dado::::::::

    interface UserView: View {

        fun getLista(list:ArrayList<UltimaSenha>)
        fun showSenha(senha:String)

    }

    //Enviando dado::::::::

    interface UserActionsListener < T : View> : Presenter<T> {

        fun generatePass(tipoSenha: String)

    }

}