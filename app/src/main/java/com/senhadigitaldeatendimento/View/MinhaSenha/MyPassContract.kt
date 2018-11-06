package com.senhadigitaldeatendimento.View.MinhaSenha
import com.senhadigitaldeatendimento.Model.MinhaSenha
import com.senhadigitaldeatendimento.Model.Senhas
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface MyPassContract {

    interface UserView: View {

        fun obterMinhaSenha(senha:String, categoria: String, hora: String)

    }

    interface UserActionsListener < T : View> : Presenter<T> {


        fun getMinhaSenha()

    }

}