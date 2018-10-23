package com.senhadigitaldeatendimento.View.MainActivityBottomNav

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.View.HistoricoSenhas.HistoricoFragment
import com.senhadigitaldeatendimento.View.Home.HomeFragment
import com.senhadigitaldeatendimento.View.Menu.MenuFragment
import com.senhadigitaldeatendimento.View.Outros.OutrosFragment
import com.senhadigitaldeatendimento.View.Painel.PainelFragment

class BottomNavigationActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    private var controlInflate = false

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_dashboard -> {
                    val fragment = PainelFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_notifications -> {
                    var fragment = HistoricoFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_menu -> {
                    var fragment = MenuFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_outros ->{
                    var fragment = OutrosFragment()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }

    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var view = findViewById<BottomNavigationView>(R.id.navigation)

        view.menu.getItem(2).isChecked = true

        content = findViewById(R.id.content) as FrameLayout
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



        val fragment = HomeFragment.newInstance()
        addFragment(fragment)
    }

}

