package com.senhadigitaldeatendimento.Support.Base


interface Presenter<T : View> {

    var view: T?

    fun onDestroy(){
        view = null

    }

}