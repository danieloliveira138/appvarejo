package com.danieloliveira.viavarejo

import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.danieloliveira.viavarejo.view.activitys.MainActivity
import com.danieloliveira.viavarejo.view.holders.HolderButtonNoBackGround
import com.danieloliveira.viavarejo.view.holders.IBaseHolder
import com.danieloliveira.viavarejo.view.holders.ProductHolder
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityInstrumentedTest {

    private val codeVersion = BuildConfig.VERSION_CODE
    private val nameVersion = BuildConfig.VERSION_NAME
    private val DELAY = 1L

    @get:Rule
    var rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun uiComponentsTest() {
        onView(withId(R.id.homeTitle)).check(matches(isDisplayed()))
        Log.d("UI_TEST", "Home Title is Displayed")
        onView(withId(R.id.versionName)).check(matches(withText("VERSION ($nameVersion)")))
        Log.d("UI_TEST", "Name version is displayed with VERSION: $nameVersion")
        onView(withId(R.id.versionCode)).check(matches(withText("version_code ($codeVersion)")))
        Log.d("UI_TEST", "Code version is displayed with VERSION: $codeVersion")
        SystemClock.sleep(DELAY)
    }

    @Test
    fun drawerMenuTest() {
        onView(withId(R.id.navView)).check(matches(not(isDisplayed())))
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        SystemClock.sleep(DELAY)

        onView(withId(R.id.navView)).check(matches(isDisplayed()))
        onView(withText("Home")).check(matches(isDisplayed()))
        onView(withText("Produtos")).check(matches(isDisplayed()))
        SystemClock.sleep(DELAY)

        onView(withText("Home")).perform(click())
        onView(withId(R.id.navView)).check(matches(not(isDisplayed())))

        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withText("Produtos")).perform(click())

        onView(withId(R.id.recyclerProducts)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerProducts)).perform(RecyclerViewActions.scrollToPosition<ProductHolder>(19))
        onView(withId(R.id.recyclerProducts)).perform(RecyclerViewActions.actionOnItemAtPosition<ProductHolder>(19, click()))
        SystemClock.sleep(DELAY)

        onView(withId(R.id.recyclerDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerDetail)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))

    }

}