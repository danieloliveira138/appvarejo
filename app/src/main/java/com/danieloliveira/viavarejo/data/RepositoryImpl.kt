package com.danieloliveira.viavarejo.data

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.DetailData
import com.danieloliveira.viavarejo.models.OtherProduct
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.models.ProductsResponse
import com.danieloliveira.viavarejo.utils.getJsonFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
            BiFunction<ProductDetail, List<OtherProduct>, DetailData> { t1, t2 ->
                DetailData(detail = t1, other = t2)
            })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    override fun requestProductsFromMockAssets(observer: Observer<ProductsResponse>) {
        val ProdMockjson = getJsonFile(R.raw.produtos, context)
        val productList = Gson().fromJson<ProductsResponse>(ProdMockjson, ProductsResponse::class.java)
        observer.onNext(productList)
        observer.onComplete()
    }

    override fun requestProductDetailFromMockAssets(observer: Observer<DetailData>) {
        val json = getJsonFile(R.raw.detalhe_produto, context)
        val productDetail = Gson().fromJson<ProductDetail>(json, ProductDetail::class.java)

        val otherProdMockjson = getJsonFile(R.raw.quem_viu_comprou, context)
        val otherProdResponse =
            Gson().fromJson<List<OtherProduct>>(otherProdMockjson,
                object : TypeToken<List<OtherProduct>>() {}.type)
        observer.onNext(DetailData(detail = productDetail, other = otherProdResponse))
        observer.onComplete()
    }
}