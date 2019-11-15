package com.danieloliveira.viavarejo.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.custom.ItemDecorationGridLayout
import com.danieloliveira.viavarejo.models.ProductsResponse
import com.danieloliveira.viavarejo.utils.getJsonFile
import com.danieloliveira.viavarejo.view.adapters.Orientation
import com.danieloliveira.viavarejo.view.adapters.ProductsAdapter
import com.danieloliveira.viavarejo.viewmodel.ProductsViewModel
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.products_fragment.*

class ProductsFragment : BaseFragment(), Observer<ProductsResponse> {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: ProductsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.products_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)

        viewModel.requestProducts(this)

        val ProdMockjson = getJsonFile(R.raw.produtos, activity!!.applicationContext)
        val productList = Gson().fromJson<ProductsResponse>(ProdMockjson, ProductsResponse::class.java)

        recyclerProducts.apply {
            adapter = ProductsAdapter(Orientation.VERTICAL, productList.produtos)
            this.addItemDecoration(ItemDecorationGridLayout(false, 1, 2))
        }
    }

    override fun onComplete() {
        Log.d("SERVER", viewModel.products.toString())
    }

    override fun onSubscribe(d: Disposable) {
        viewModel.disposable = d
    }

    override fun onNext(t: ProductsResponse) {
        viewModel.products.addAll(t.produtos)
    }

    override fun onError(e: Throwable) {
        Log.d("ERROR", String.format("${e.message}"))
    }

    override fun onDestroy() {
        viewModel.destroy(viewModel.disposable)
        super.onDestroy()
    }
}
