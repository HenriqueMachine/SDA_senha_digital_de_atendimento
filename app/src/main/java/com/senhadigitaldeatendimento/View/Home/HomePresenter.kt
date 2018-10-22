package com.senhadigitaldeatendimento.View.Home

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.senhadigitaldeatendimento.Model.UltimaSenha
import com.google.gson.reflect.TypeToken



class HomePresenter (var context: Context?,
                     override var view: HomeContract.UserView?) :
        HomeContract.UserActionsListener<HomeContract.UserView> {

    private var sp:SharedPreferences.Editor? = null

    private val ULTIMAS_SENHAS = "ULTIMAS"
    private val SENHAS_LIST = "ULTIMAS"

    private var senha = 0
    private  var senha_topico:String? = null



    override fun generatePass(tipoSenha: String) {

        if(senha <= senha){
            senha += 1
        }

        senha_topico = "$tipoSenha $senha"

        saveSenhaInList(tipoSenha,senha)

        view?.showSenha(senha_topico!!)

    }

    fun saveSenhaInList(topic:String,senha:Int){

        val list = getSenhas()

        list.add(UltimaSenha(topic,senha))

        sp = context?.getSharedPreferences(SENHAS_LIST,MODE_PRIVATE)?.edit()
        sp?.putString(ULTIMAS_SENHAS, Gson().toJson(list))
        sp?.apply()

    }

    fun getSenhas():ArrayList<UltimaSenha>{

        var list:ArrayList<UltimaSenha> = ArrayList()

        val sp = context?.getSharedPreferences(SENHAS_LIST,MODE_PRIVATE)

        val gson = sp?.getString(ULTIMAS_SENHAS,"")

        if (gson.isNullOrEmpty()){

            val listType = object : TypeToken<ArrayList<UltimaSenha>>() {

            }.type

            list = Gson().fromJson(gson,listType)

        }

        view?.getLista(list)

        return list
    }
}