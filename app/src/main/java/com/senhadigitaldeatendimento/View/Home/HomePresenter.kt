package com.senhadigitaldeatendimento.View.Home

import android.content.Context
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas

class HomePresenter (var context: Context?,
                     override var view: HomeContract.UserView?) :
        HomeContract.UserActionsListener<HomeContract.UserView> {

    override fun saveMyPass(categoria: String, hora: String, senha: String) {

        GetSenhas.saveMyPassInList(categoria, hora, senha, context)


    }

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