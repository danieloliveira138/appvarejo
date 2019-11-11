package com.danieloliveira.viavarejo.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.ProductsResponse
import com.danieloliveira.viavarejo.utils.getJsonFile
import com.danieloliveira.viavarejo.view.adapters.ProductsAdapter
import com.danieloliveira.viavarejo.viewmodel.ProductsViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.products_fragment.*

class ProductsFragment : BaseFragment() {

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
        val json = getJsonFile(R.raw.produtos, activity!!.applicationContext)
        val productList = Gson().fromJson<ProductsResponse>(json, ProductsResponse::class.java)
        Log.d("MOCK_RESPONSE", "JSON: $json")

        recyclerProducts.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ProductsAdapter(productList.produtos)
        }
    }

}
