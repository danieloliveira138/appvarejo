package com.danieloliveira.viavarejo.models

import androidx.fragment.app.Fragment

data class FragmentData(
    val fragment: Fragment,
    val TAG: String,
    val enterAnim: Int,
    val exitAnim: Int
)