package com.senhadigitaldeatendimento.Support.Utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.senhadigitaldeatendimento.Model.MinhaSenha
import com.senhadigitaldeatendimento.Model.Senhas

object GetSenhas {

    private const val ULTIMAS_SENHAS = "ULTIMAS"
    private const val SENHAS_LIST = "ULTIMAS_LIST"

    private const val MINHAS_SENHAS = "MINHASSENHALIST"
    private const val MINHASSENHAS_LIST = "MINHASSENHAS_LIST"


    private var sp: SharedPreferences.Editor? = null

    fun saveSenhaInList(topic:String,senha:Int,context: Context?){

        val list = getSenhas(context)

        list.add(Senhas(topic,senha))

        sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)?.edit()
        sp?.putString(ULTIMAS_SENHAS, Gson().toJson(list))
        sp?.apply()

    }

    fun getSenhas(context: Context?):ArrayList<Senhas>{

        var list:ArrayList<Senhas> = ArrayList()

        val sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)

        val gson = sp?.getString(ULTIMAS_SENHAS,"")

        if (!gson.isNullOrEmpty()){

            val listType = object : TypeToken<ArrayList<Senhas>>() {

            }.type

            list = Gson().fromJson(gson,listType)

        }

        return list
    }

    fun getMyPass(context: Context?):ArrayList<MinhaSenha>{

        var list:ArrayList<MinhaSenha> = ArrayList()

        val sp = context?.getSharedPreferences(MINHASSENHAS_LIST, Context.MODE_PRIVATE)

        val gson = sp?.getString(MINHAS_SENHAS,"")

        if (!gson.isNullOrEmpty()){

            val listType = object : TypeToken<ArrayList<MinhaSenha>>() {

            }.type

            list = Gson().fromJson(gson,listType)

        }

        return list
    }

    fun saveMyPassInList(categoria:String,senha:String,hour:String,context: Context?){

        val list = getMyPass(context)

        list.add(MinhaSenha(categoria,senha,hour))

        sp = context?.getSharedPreferences(MINHASSENHAS_LIST, Context.MODE_PRIVATE)?.edit()
        sp?.putString(MINHAS_SENHAS, Gson().toJson(list))
        sp?.apply()

    }

    fun removeSharedPref(context: Context?){

        sp = context?.getSharedPreferences(SENHAS_LIST, Context.MODE_PRIVATE)?.edit()
        sp?.remove(ULTIMAS_SENHAS)

        sp?.apply()
    }

}