package com.senhadigitaldeatendimento.View.HistoricoSenhas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout

import com.senhadigitaldeatendimento.R
import kotlinx.android.synthetic.main.fragment_historico.*

class HistoricoFragment : Fragment(), HistoricoSenhasContract.UserView {

    private val presenter: HistoricoSenhasContract.UserActionsListener<HistoricoSenhasContract.UserView> by lazy {
        HistoricoSenhasPresenter(activity, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico, container, false)

    }

}
