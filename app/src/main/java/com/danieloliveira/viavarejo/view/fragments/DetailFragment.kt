package com.danieloliveira.viavarejo.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.data.DetailData
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

class DetailFragment : BaseFragment(), Observer<DetailData> {

    companion object {
        fun newInstance(id: Int): DetailFragment {
            val fragment = DetailFragment()
            val bundle = bundleOf("Product_Id" to id)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        val json = getJsonFile(R.raw.detalhe_produto, activity!!.applicationContext)
        val productDetail = Gson().fromJson<ProductDetail>(json, ProductDetail::class.java)

        val otherProdMockjson = getJsonFile(R.raw.quem_viu_comprou, activity!!.applicationContext)
        val otherProdResponse =
            Gson().fromJson<List<OtherProduct>>(otherProdMockjson, object : TypeToken<List<OtherProduct>>() {}.type)

        Log.d("OUTROS_PRODUTOS", otherProdResponse.toString())

        viewModel.requestProductDetail(this)
    }

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        viewModel.disposable = d
    }

    override fun onNext(t: DetailData) {
        t?.let {
            setupRecycler(it)
        }
    }

    override fun onError(e: Throwable) {
        Toast.makeText(this.context, "Erro na requisição", Toast.LENGTH_SHORT).show()
        Log.d("RX_ERROR", String.format("ERROR: ${e.message}"))
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.destroy(viewModel.disposable)
    }

    private fun setupRecycler(detailData: DetailData) {
        recyclerDetail.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = DetailAdapter(detailData.detail, detailData.other, fragmentManager)
        }
    }
}
