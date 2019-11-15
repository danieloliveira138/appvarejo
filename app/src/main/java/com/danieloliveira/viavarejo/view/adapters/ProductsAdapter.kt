package com.danieloliveira.viavarejo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.Produto
import com.danieloliveira.viavarejo.view.holders.ProductHolder

class ProductsAdapter(
    private val orientation: Orientation,
    private val productsList: List<Produto>
):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (orientation) {
            Orientation.HORIZONTAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.product_holder_limited_size, parent, false)
                ProductHolder(view)
            }
            Orientation.VERTICAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.product_holder, parent, false)
                ProductHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = productsList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ProductHolder
        holder.bind(productsList[position])
    }
}

enum class Orientation {
    HORIZONTAL, VERTICAL
}