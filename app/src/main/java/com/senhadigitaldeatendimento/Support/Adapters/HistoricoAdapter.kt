package com.senhadigitaldeatendimento.Support.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.Senhas
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.MyViewHolder
import kotlinx.android.synthetic.main.item_ultima_senha.view.*

class HistoricoAdapter (var mLista: ArrayList<Senhas>,
                        val context:Context) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view : View = LayoutInflater.from(p0.context).inflate(R.layout.item_historico,p0,false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {

        return mLista.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val item:Senhas = mLista[p1]

        p0.itemView.textview_tipo_senha.text = item.topico
        p0.itemView.textview_numero_senha.text = item.numeroSenha.toString()

    }
}