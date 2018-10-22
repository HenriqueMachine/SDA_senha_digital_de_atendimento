package com.senhadigitaldeatendimento.View.Painel


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.senhadigitaldeatendimento.R

class PainelFragment : Fragment(), PainelContract.UserView {

    private val presenter : PainelContract.UserActionsListener<PainelContract.UserView> by lazy {
        PainelPresenter(activity,this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_painel, container, false)


    }

}
