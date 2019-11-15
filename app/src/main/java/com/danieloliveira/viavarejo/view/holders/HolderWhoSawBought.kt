package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.utils.castToListProductosResponse
import com.danieloliveira.viavarejo.utils.isListProductsResponse
import com.danieloliveira.viavarejo.utils.toProdutoList
import com.danieloliveira.viavarejo.view.adapters.Orientation
import com.danieloliveira.viavarejo.view.adapters.ProductsAdapter
import kotlinx.android.synthetic.main.holder_horizontal_list.view.*
import kotlinx.android.synthetic.main.textview_holder_title.view.*

class HolderWhoSawBought(private val view: View): RecyclerView.ViewHolder(view), IBaseHolder {
    override fun bind(data: Any) {
        view.title.text = String.format("Quem viu Comprou")
        if (data.isListProductsResponse()) {
            val listProduto = data.castToListProductosResponse()
            view.recyclerView.apply {
                layoutManager = LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.HORIZONTAL,
                    false)
                setHasFixedSize(true)
                adapter = ProductsAdapter(Orientation.HORIZONTAL, listProduto.toProdutoList())
            }
        }
    }

}