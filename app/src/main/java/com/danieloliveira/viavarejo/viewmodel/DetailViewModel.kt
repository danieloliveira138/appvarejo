package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.data.DetailData
import com.danieloliveira.viavarejo.data.Repository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class DetailViewModel : BaseViewModel() {

    val repository = Repository()
    var disposable: Disposable? = null

    fun requestProductDetail(observer: Observer<DetailData>) = repository.requestProductDet(observer)


}
