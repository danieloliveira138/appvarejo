package com.danieloliveira.viavarejo.enums

import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.FragmentData
import com.danieloliveira.viavarejo.view.fragments.HomeFragment
import com.danieloliveira.viavarejo.view.fragments.ProductsFragment

enum class FragmentRoute(val fragment: FragmentData) {
    HOME(
        FragmentData(
            fragment = HomeFragment.newInstance(),
            TAG = "Home",
            enterAnim = R.anim.enter_right,
            exitAnim = R.anim.enter_left)),
    PRODUCTS(
        FragmentData(
            fragment = ProductsFragment.newInstance(),
            TAG = "Products",
            enterAnim = R.anim.enter_left,
            exitAnim = R.anim.enter_right))
}