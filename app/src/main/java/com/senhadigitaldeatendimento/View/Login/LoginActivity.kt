package com.senhadigitaldeatendimento.View.Login


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.senhadigitaldeatendimento.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

}
