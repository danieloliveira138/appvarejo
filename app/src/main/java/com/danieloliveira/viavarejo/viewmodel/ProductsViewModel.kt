package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.data.Repository
import com.danieloliveira.viavarejo.models.ProductsResponse
import com.danieloliveira.viavarejo.models.Produto
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ProductsViewModel : BaseViewModel() {

    val repository = Repository()
    var products = mutableListOf<Produto>()
    var disposable: Disposable? = null

    fun requestProducts(observer: Observer<ProductsResponse>) = repository.requestProducts(observer)

}
