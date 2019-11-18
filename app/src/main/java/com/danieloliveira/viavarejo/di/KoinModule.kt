package com.danieloliveira.viavarejo.di

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.danieloliveira.viavarejo.data.Repository
import com.danieloliveira.viavarejo.data.RepositoryImpl
import com.danieloliveira.viavarejo.data.RetrofitConfig
import com.danieloliveira.viavarejo.view.adapters.DetailAdapter
import com.danieloliveira.viavarejo.view.adapters.Orientation
import com.danieloliveira.viavarejo.view.adapters.ProductsAdapter
import com.danieloliveira.viavarejo.view.fragments.ProductsFragment
import com.danieloliveira.viavarejo.viewmodel.DetailViewModel
import com.danieloliveira.viavarejo.viewmodel.HomeViewModel
import com.danieloliveira.viavarejo.viewmodel.ProductsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule : Module = module {

    viewModel { HomeViewModel() }

    viewModel { ProductsViewModel(get()) }

    viewModel { DetailViewModel(get()) }

    single { ProductsFragment() }

    single<Repository> { RepositoryImpl(get(), get()) }

    single { RetrofitConfig().getService() }

    factory { (fragmentManager: FragmentManager, activity: Activity) -> DetailAdapter(fragmentManager, activity) }

    factory { (orientation: Orientation) -> ProductsAdapter(orientation) }
}