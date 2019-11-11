package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.holder_product_image.view.productImage

class HolderProductImage(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(imageUrl: String) {
        Glide.with(view)
            .load(imageUrl)
            .into(view.productImage)
    }

}