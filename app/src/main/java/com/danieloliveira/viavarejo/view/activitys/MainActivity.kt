package com.danieloliveira.viavarejo.view.activitys

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import android.view.Menu
import androidx.fragment.app.commitNow
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.enums.FragmentRoute
import com.danieloliveira.viavarejo.model.FragmentData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setHomeFragment(FragmentRoute.HOME)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentData =
            when (item.itemId) {
                R.id.nav_home -> setHomeFragment(FragmentRoute.HOME)
                R.id.nav_products -> setHomeFragment(FragmentRoute.PRODUCTS)
                else -> return false
            }
        drawerLayout.closeDrawer(GravityCompat.START)
        toolbar.title = fragmentData.TAG
        return true
    }

    private fun setHomeFragment(fragmentRouter: FragmentRoute): FragmentData {
        val fragmentData = fragmentRouter.fragment
        supportFragmentManager.commitNow(allowStateLoss = false) {
            setCustomAnimations(R.anim.enter_left, R.anim.exit_right, R.anim.enter_right, R.anim.exit_left)
            replace(R.id.fragmentContent, fragmentData.fragment, fragmentData.TAG)
        }
        return fragmentData
    }

}
