package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.data.DetailData
import com.danieloliveira.viavarejo.data.Repository
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

class DetailViewModel : BaseViewModel() {

    val repository = Repository()
    var disposable: Disposable? = null

    fun requestProductDetail(consumer: Consumer<DetailData>) = repository.requestProductDet(consumer)


}
