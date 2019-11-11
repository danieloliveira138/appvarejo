package com.danieloliveira.viavarejo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.Produto
import com.danieloliveira.viavarejo.view.holders.ProductHolder

class ProductsAdapter(private val productsList: List<Produto>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_holder, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int = productsList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ProductHolder
        holder.bind(productsList[position])
    }
}