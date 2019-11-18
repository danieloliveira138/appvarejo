package com.danieloliveira.viavarejo.data

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.danieloliveira.viavarejo.models.DetailData
import com.danieloliveira.viavarejo.models.OtherProduct
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.models.ProductsResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val service: ViaVarejoService,
                     private val context: Context): Repository {

    override fun hasNetworkEnable(): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected == true
    }

    override fun requestProducts(observer: Observer<ProductsResponse>) =
        service.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    override fun requestProductDetail(observer: Observer<DetailData>) =
        Observable.zip(
            service.getProduct(),
            service.getOtherProducts(),
            object : BiFunction<ProductDetail, List<OtherProduct>, DetailData> {
                override fun apply(t1: ProductDetail, t2: List<OtherProduct>): DetailData {
                    Log.d("ZIP_RX", "ZIP CALLING")
                    return DetailData(detail = t1, other = t2)
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
}