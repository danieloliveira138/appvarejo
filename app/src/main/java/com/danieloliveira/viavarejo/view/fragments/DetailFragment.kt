package com.danieloliveira.viavarejo.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.DetailData
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.models.OtherProduct
import com.danieloliveira.viavarejo.utils.getJsonFile
import com.danieloliveira.viavarejo.view.adapters.DetailAdapter
import com.danieloliveira.viavarejo.viewmodel.DetailViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.recycler_layout.*
import org.jetbrains.anko.design.snackbar
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : BaseFragment(), Observer<DetailData> {

    companion object {
        fun newInstance(id: Int): DetailFragment {
            val fragment = DetailFragment()
            val bundle = bundleOf("Product_Title" to id)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var fragmentView: View
    private val detailViewModel: DetailViewModel by viewModel()
    private val detailAdapter: DetailAdapter by inject{ parametersOf(fragmentManager, this.activity) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView =  inflater.inflate(R.layout.recycler_layout, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val json = getJsonFile(R.raw.detalhe_produto, activity!!.applicationContext)
        val productDetail = Gson().fromJson<ProductDetail>(json, ProductDetail::class.java)

        val otherProdMockjson = getJsonFile(R.raw.quem_viu_comprou, activity!!.applicationContext)
        val otherProdResponse =
            Gson().fromJson<List<OtherProduct>>(otherProdMockjson, object : TypeToken<List<OtherProduct>>() {}.type)

        Log.d("OUTROS_PRODUTOS", otherProdResponse.toString())

        setupRecycler()

        detailViewModel.requestProductDetail(this)

    }

    override fun onComplete() {
        detailAdapter.notifyDataSetChanged()
    }

    override fun onSubscribe(d: Disposable) {
        detailViewModel.disposable = d
    }

    override fun onNext(detailData: DetailData) {
        detailViewModel.detailData = detailData
        detailAdapter.insertData(detailViewModel.detailData)
    }

    override fun onError(e: Throwable) {
        fragmentView.snackbar(e.message!!)
    }


    override fun onDestroy() {
        super.onDestroy()
        detailViewModel.destroy(detailViewModel.disposable)
    }

    private fun setupRecycler() {
        recyclerDetail.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = detailAdapter
        }
    }
}
