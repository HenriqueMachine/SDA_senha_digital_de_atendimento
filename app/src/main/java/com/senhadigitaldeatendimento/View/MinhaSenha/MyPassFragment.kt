package com.senhadigitaldeatendimento.View.MinhaSenha


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas
class MyPassFragment : Fragment(), MyPassContract.UserView {

    private val presenter : MyPassContract.UserActionsListener<MyPassContract.UserView> by lazy {
        MyPassPresenter(activity,this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        presenter.getMyPass()

        return inflater.inflate(R.layout.fragment_minhasenha, container, false)

    }

}
