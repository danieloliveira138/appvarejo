package com.danieloliveira.viavarejo.view.activitys

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.enums.FragmentRoute
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        homeFragment()
        setupDrawerMenu()

    }

    override fun setupDrawerMenu() {
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun homeFragment() {
        selectFragment(FragmentRoute.HOME)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentData =
            when (item.itemId) {
                R.id.nav_home -> selectFragment(FragmentRoute.HOME, animated = true)
                R.id.nav_products -> selectFragment(FragmentRoute.PRODUCTS, animated = true)
                else -> return false
            }
        drawerLayout.closeDrawer(GravityCompat.START)
        toolbar.title = fragmentData.TAG
        return true
    }
}
