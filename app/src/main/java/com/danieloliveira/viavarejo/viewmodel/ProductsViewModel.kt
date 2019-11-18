package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.data.Repository
import com.danieloliveira.viavarejo.data.RepositoryImpl
import com.danieloliveira.viavarejo.models.ProductsResponse
import com.danieloliveira.viavarejo.models.Produto
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.nio.channels.NetworkChannel

class ProductsViewModel(private val repository: Repository) : BaseViewModel() {

    var products = mutableListOf<Produto>()
    var disposable: Disposable? = null

    fun connectionState() : Boolean = repository.hasNetworkEnable()

    fun requestProducts(observer: Observer<ProductsResponse>){
        if (connectionState())
            repository.requestProducts(observer)
        else
            observer.onError(Throwable(message = "Ops, sem internet no momento!"))
    }

}
