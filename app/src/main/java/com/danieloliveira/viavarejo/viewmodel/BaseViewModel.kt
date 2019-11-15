package com.danieloliveira.viavarejo.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {
    fun destroy(disposable: Disposable?) {
        disposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }
}