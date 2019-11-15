package com.danieloliveira.viavarejo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.danieloliveira.viavarejo.BuildConfig
import com.danieloliveira.viavarejo.models.VersionInformation

class HomeViewModel : ViewModel() {

    fun getVersionNameAndCode(): VersionInformation =
        VersionInformation(BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE)

}
