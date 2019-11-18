package com.danieloliveira.viavarejo.data

import com.danieloliveira.viavarejo.models.DetailData
import com.danieloliveira.viavarejo.models.ProductsResponse
import io.reactivex.Observer

interface Repository {
    fun requestProducts(observer: Observer<ProductsResponse>)
    fun requestProductDetail(observer: Observer<DetailData>)
    fun hasNetworkEnable(): Boolean

    fun requestProductsFromMockAssets(observer: Observer<ProductsResponse>)
    fun requestProductDetailFromMockAssets(observer: Observer<DetailData>)
}