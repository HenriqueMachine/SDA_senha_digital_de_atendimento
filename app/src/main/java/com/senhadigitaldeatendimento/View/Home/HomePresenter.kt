package com.senhadigitaldeatendimento.View.Home

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.google.gson.reflect.TypeToken
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class HomePresenter (var context: Context?,
                     override var view: HomeContract.UserView?) :
        HomeContract.UserActionsListener<HomeContract.UserView> {

    private var senha = 0
    private  var senha_topico:String? = null

    override fun generatePass(tipoSenha: String) {

        if(senha <= senha){
            senha += 1
        }

        senha_topico = "$tipoSenha $senha"

        GetSenhas.saveSenhaInList(tipoSenha,senha,context)

        view?.showSenha(senha_topico!!)

    }
}