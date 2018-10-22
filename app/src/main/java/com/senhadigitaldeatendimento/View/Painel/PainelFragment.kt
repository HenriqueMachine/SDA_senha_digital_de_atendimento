package com.senhadigitaldeatendimento.View.Painel


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.UltimaSenha

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Adapters.UltimaSenhaAdapter
import kotlinx.android.synthetic.main.fragment_painel.*

@Suppress("UNREACHABLE_CODE")
class PainelFragment : Fragment(), PainelContract.UserView {

    private val presenter : PainelContract.UserActionsListener<PainelContract.UserView> by lazy {
        PainelPresenter(activity,this)
    }
    private var adapter:UltimaSenhaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_painel, container, false)

    }

    override fun setList(list: ArrayList<UltimaSenha>) {

        recyclerview_table1.layoutManager = GridLayoutManager( activity, 2,
                GridLayoutManager.HORIZONTAL,
                false
        )
        adapter = UltimaSenhaAdapter(list, this.activity!!)
        recyclerview_table1.adapter = adapter

    }

}
