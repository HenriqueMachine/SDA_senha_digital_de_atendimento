package com.senhadigitaldeatendimento.View.HistoricoSenhas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senhadigitaldeatendimento.Model.Senhas

import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Adapters.HistoricoAdapter
import kotlinx.android.synthetic.main.fragment_historico.*

class HistoricoFragment : Fragment(), HistoricoSenhasContract.UserView {

    private val presenter: HistoricoSenhasContract.UserActionsListener<HistoricoSenhasContract.UserView> by lazy {
        HistoricoSenhasPresenter(activity, this) }

    private var adapter: HistoricoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.historicoSet()

    }

    override fun obterHistorico(list: ArrayList<Senhas>) {

        recyclerview_historico.layoutManager = LinearLayoutManager( activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        adapter = HistoricoAdapter(list, this.activity!!)
        recyclerview_historico.adapter = adapter

    }


}
