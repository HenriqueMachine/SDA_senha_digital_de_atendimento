package com.senhadigitaldeatendimento.View.BemvindoInitial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.View.Login.LoginActivity
import com.senhadigitaldeatendimento.View.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_apresentacao.*

class ApresentacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apresentacao)

        button_entrar.setOnClickListener {

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        button_cadastrar.setOnClickListener {

            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

    }
}
