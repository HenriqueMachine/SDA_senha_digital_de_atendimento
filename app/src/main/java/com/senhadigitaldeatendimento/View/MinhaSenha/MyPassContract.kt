package com.senhadigitaldeatendimento.View.MinhaSenha
import com.senhadigitaldeatendimento.Support.Base.Presenter
import com.senhadigitaldeatendimento.Support.Base.View

interface MyPassContract {

    interface UserView: View {



    }

    interface UserActionsListener < T : View> : Presenter<T> {


        fun getMyPass()

    }

}