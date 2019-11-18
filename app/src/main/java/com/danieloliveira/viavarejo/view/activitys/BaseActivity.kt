package com.danieloliveira.viavarejo.view.activitys

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.enums.FragmentRoute
import com.danieloliveira.viavarejo.models.FragmentData
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

abstract class BaseActivity: AppCompatActivity() {

    fun selectFragment(fragmentRouter: FragmentRoute, animated: Boolean = false): FragmentData {
        val fragmentData = fragmentRouter.fragment
        supportFragmentManager.commitNow(allowStateLoss = false) {
            if(animated) {
                setCustomAnimations(R.anim.enter_left, R.anim.exit_right, R.anim.enter_right, R.anim.exit_left)
            }
            replace(R.id.fragmentContent, fragmentData.fragment, fragmentData.TAG)
        }
        return fragmentData
    }

    abstract fun homeFragment()

    abstract fun setupToolbar()

    abstract fun setupDrawerMenu()

    fun alertmessage(message: String) {
        alert {
            this.message = message
            yesButton { }
        }.show()
    }

}