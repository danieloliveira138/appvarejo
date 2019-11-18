package com.danieloliveira.viavarejo.view.fragments

import android.os.Bundle
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
import org.jetbrains.anko.design.snackbar
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ProductsFragment : BaseFragment(), Observer<ProductsResponse> {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var fragmentView: View
    private val productsViewModel: ProductsViewModel by viewModel()
    private val productsAdapter: ProductsAdapter by inject { parametersOf(Orientation.HORIZONTAL) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        fragmentView = inflater.inflate(R.layout.products_fragment, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecycler()

        productsViewModel.requestProducts(this)

        val ProdMockjson = getJsonFile(R.raw.produtos, activity!!.applicationContext)
        val productList = Gson().fromJson<ProductsResponse>(ProdMockjson, ProductsResponse::class.java)

    }

    override fun onComplete() {
        productsAdapter.notifyDataSetChanged()
    }

    override fun onSubscribe(d: Disposable) {
        productsViewModel.disposable = d
    }

    override fun onNext(t: ProductsResponse) {
        productsViewModel.products.addAll(t.produtos)
        productsAdapter.insertData(productsViewModel.products)
    }

    override fun onError(e: Throwable) {
        fragmentView.snackbar(e.message!!)
    }

    override fun onDestroy() {
        productsViewModel.destroy(productsViewModel.disposable)
        super.onDestroy()
    }

    private fun setupRecycler() {
        recyclerProducts.apply {
            adapter = productsAdapter
            this.addItemDecoration(ItemDecorationGridLayout(false, 1, 2))
        }
    }
}
