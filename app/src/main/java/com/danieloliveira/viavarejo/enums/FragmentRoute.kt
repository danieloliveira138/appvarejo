package com.danieloliveira.viavarejo.enums

import com.danieloliveira.viavarejo.model.FragmentData
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
            TAG = "Products")),
}