package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.BuildConfig
import com.danieloliveira.viavarejo.models.VersionInformation

class HomeViewModel : BaseViewModel() {

    fun getVersionNameAndCode(): VersionInformation =
        VersionInformation(BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE)

}
