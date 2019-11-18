package com.danieloliveira.viavarejo.view.holders

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.view.adapters.Orientation
import com.danieloliveira.viavarejo.view.adapters.ProductsAdapter
import kotlinx.android.synthetic.main.holder_horizontal_list.view.*
import kotlinx.android.synthetic.main.textview_holder_title.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HolderWhoSawBought(private val view: View, private val activity: Activity): RecyclerView.ViewHolder(view), IBaseHolder {

    private val productsAdapter: ProductsAdapter by activity.inject { parametersOf(Orientation.HORIZONTAL) }

    override fun bind(data: Any) {
        view.title.text = String.format("Quem viu Comprou")

        view.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                view.context,
                LinearLayoutManager.HORIZONTAL,
                false)
            setHasFixedSize(true)
            adapter = productsAdapter
        }

        productsAdapter.insertData(data)
        productsAdapter.notifyDataSetChanged()
    }


}