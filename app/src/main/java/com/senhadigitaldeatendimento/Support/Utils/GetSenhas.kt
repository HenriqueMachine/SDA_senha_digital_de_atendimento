package com.senhadigitaldeatendimento.Support.Utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.senhadigitaldeatendimento.Model.UltimaSenha

object GetSenhas {

    private const val ULTIMAS_SENHAS = "ULTIMAS"
    private const val SENHAS_LIST = "ULTIMAS_LIST"
    private var sp: SharedPreferences.Editor? = null

    fun saveSenhaInList(topic:String,senha:Int,context: Context?){

        val list = getSenhas(context)

        list.add(UltimaSenha(topic,senha))

        sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)?.edit()
        sp?.putString(ULTIMAS_SENHAS, Gson().toJson(list))
        sp?.apply()

    }

    fun getSenhas(context: Context?):ArrayList<UltimaSenha>{

        var list:ArrayList<UltimaSenha> = ArrayList()

        val sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)

        val gson = sp?.getString(ULTIMAS_SENHAS,"")

        if (!gson.isNullOrEmpty()){

            val listType = object : TypeToken<ArrayList<UltimaSenha>>() {

            }.type

            list = Gson().fromJson(gson,listType)

        }

        return list
    }

    fun removeSharedPref(context: Context?){

        sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)?.edit()
        sp?.remove(ULTIMAS_SENHAS)

        sp?.apply()
    }

}