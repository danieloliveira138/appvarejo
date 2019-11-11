package com.danieloliveira.viavarejo.enums

import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.FragmentData
import com.danieloliveira.viavarejo.view.fragments.DetailFragment
import com.danieloliveira.viavarejo.view.fragments.HomeFragment
import com.danieloliveira.viavarejo.view.fragments.ProductsFragment

enum class FragmentRoute(val fragment: FragmentData) {
    HOME(
        FragmentData(
            fragment = HomeFragment.newInstance(),
            TAG = "Home")),
    PRODUCTS(
        FragmentData(
            fragment = ProductsFragment.newInstance(),
            TAG = "Products"))
}