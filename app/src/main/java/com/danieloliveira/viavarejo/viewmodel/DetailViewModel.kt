package com.danieloliveira.viavarejo.viewmodel

import com.danieloliveira.viavarejo.data.Repository
import com.danieloliveira.viavarejo.models.DetailData
import com.danieloliveira.viavarejo.data.RepositoryImpl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    var detailData: DetailData = DetailData()

    var disposable: Disposable? = null

    fun connectionState() : Boolean = repository.hasNetworkEnable()

    fun requestProductDetail(observer: Observer<DetailData>) {
        if (connectionState())
            repository.requestProductDetail(observer)
        else
            observer.onError(Throwable(message = "Ops, você esta sem internet no momento!"))
    }


}
