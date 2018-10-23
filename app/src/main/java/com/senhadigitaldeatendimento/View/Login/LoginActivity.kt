package com.senhadigitaldeatendimento.View.Login


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.View.MainActivityBottomNav.BottomNavigationActivity
import com.senhadigitaldeatendimento.View.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_sign_in_button.setOnClickListener {

                var intent = Intent(this, BottomNavigationActivity::class.java)
                startActivity(intent)



        }

    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

}
