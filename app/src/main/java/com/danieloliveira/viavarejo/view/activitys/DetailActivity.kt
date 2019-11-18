package com.danieloliveira.viavarejo.view.activitys

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commitNow
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.view.fragments.DetailFragment
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolbar()
        homeFragment()

    }

    override fun setupDrawerMenu() {
        return
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun homeFragment() {
        val fragment = DetailFragment.newInstance(-1)
        supportFragmentManager.commitNow(allowStateLoss = false) {
            replace(R.id.fragmentContent, fragment, "Detail")
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}