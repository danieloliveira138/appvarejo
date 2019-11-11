package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danieloliveira.viavarejo.models.Produto
import kotlinx.android.synthetic.main.product_holder.view.*

class ProductHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(product: Produto) {
        view.productTitle.text = product.nome

        Glide.with(view)
            .load(product.imagemUrl)
            .into(view.productImage)
    }

}