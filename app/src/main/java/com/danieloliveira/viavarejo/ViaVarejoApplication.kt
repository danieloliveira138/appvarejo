package com.danieloliveira.viavarejo

import android.app.Application
import com.danieloliveira.viavarejo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ViaVarejoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ViaVarejoApplication)
            modules(listOf(appModule))
        }
    }
}