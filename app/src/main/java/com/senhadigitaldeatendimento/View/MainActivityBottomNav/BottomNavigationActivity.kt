package com.senhadigitaldeatendimento.View.MainActivityBottomNav

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import com.senhadigitaldeatendimento.R
import com.senhadigitaldeatendimento.Support.Utils.GetSenhas
import com.senhadigitaldeatendimento.View.BemvindoInitial.ApresentacaoActivity
import com.senhadigitaldeatendimento.View.HistoricoSenhas.HistoricoFragment
import com.senhadigitaldeatendimento.View.Home.HomeFragment
import com.senhadigitaldeatendimento.View.MinhaSenha.minhasenhaFragment
import com.senhadigitaldeatendimento.View.Painel.PainelFragment
import kotlinx.android.synthetic.main.activity_menu.*

class BottomNavigationActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private var content: FrameLayout? = null

    private var controlInflate:Int? = null

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {

                    if (controlInflate != 0){
                        controlInflate = 0

                        val fragment = HomeFragment.newInstance()
                        addFragment(fragment)
                        return true

                    }

                }
                R.id.navigation_dashboard -> {

                    if (controlInflate != 1){
                        controlInflate = 1

                        val fragment = PainelFragment()
                        addFragment(fragment)
                        return true

                    }

                }
                R.id.navigation_notifications -> {

                    if (controlInflate != 2){
                        controlInflate = 2

                        var fragment = HistoricoFragment()
                        addFragment(fragment)
                        return true

                    }
                }
                R.id.navigation_menu -> {

//                    if (controlInflate != 3){
//                        controlInflate = 3
//
//                        val fragment = MenuFragment()
//                        addFragment(fragment)
//                        return true
//
//                    }
                    drawer_layout.openDrawer(Gravity.END)
                }
                R.id.navigation_outros ->{

                    if (controlInflate != 4){
                        controlInflate = 4

                        val fragment = minhasenhaFragment()
                        addFragment(fragment)
                        return true

                    }
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

        nav_view.setNavigationItemSelectedListener(this)

        val fragment = HomeFragment.newInstance()
        addFragment(fragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_exit -> {

                GetSenhas.removeSharedPref(this)

                val intent = Intent(this, ApresentacaoActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        //drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {

    }

}

