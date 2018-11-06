package com.senhadigitaldeatendimento.Support.Utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.senhadigitaldeatendimento.Model.InfosUser
import com.senhadigitaldeatendimento.Model.Senhas

object GetUser {

    private const val USUARIO = "USER"
    private const val LIST = "USER_LIST"

    private var sp: SharedPreferences.Editor? = null

    fun saveInfo(context: Context?,nome: String,cpf:String, dataNas:String,telefone:String,email:String){

        val list = getinfo(context)

        list.add(InfosUser(nome,email,dataNas,cpf,telefone))

        sp = context?.getSharedPreferences(LIST, Context.MODE_PRIVATE)?.edit()
        sp?.putString(LIST, Gson().toJson(list))
        sp?.apply()

    }

    fun getinfo(context: Context?): ArrayList<InfosUser> {

        var list:ArrayList<InfosUser> = ArrayList()

        val sp = context?.getSharedPreferences(LIST, Context.MODE_PRIVATE)

        val gson = sp?.getString(LIST,"")

        if (!gson.isNullOrEmpty()){

            val listType = object : TypeToken<ArrayList<InfosUser>>() {

            }.type

            list = Gson().fromJson(gson,listType)

        }

        return list
    }


    fun removeSharedPref(context: Context?){

        sp = context?.getSharedPreferences(LIST, Context.MODE_PRIVATE)?.edit()
        sp?.remove(USUARIO)

        sp?.apply()
    }

}