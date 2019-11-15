package com.danieloliveira.viavarejo.data

import com.danieloliveira.viavarejo.models.OtherProduct
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.models.ProductsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ViaVarejoService {

    @GET("/v2/5d1b4f0f34000074000006dd")
    fun getProducts(): Observable<ProductsResponse>

    @GET("/v2/5d1b4fd23400004c000006e1")
    fun getProduct(): Observable<ProductDetail>

    @GET("/v2/5d1b507634000054000006ed")
    fun getOtherProducts(): Observable<List<OtherProduct>>
}