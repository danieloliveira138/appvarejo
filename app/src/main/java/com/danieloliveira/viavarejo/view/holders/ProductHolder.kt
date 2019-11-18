package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.Produto
import com.danieloliveira.viavarejo.utils.brazilCurrency
import com.danieloliveira.viavarejo.utils.navigatoToActivity
import com.danieloliveira.viavarejo.utils.strike
import com.danieloliveira.viavarejo.view.activitys.DetailActivity
import com.danieloliveira.viavarejo.view.activitys.MainActivity
import kotlinx.android.synthetic.main.product_holder.view.*

class ProductHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(product: Produto) {

        view.productTitle.text = product.nome
        view.previousPrice.strike(product.preco.precoAnterior.brazilCurrency())
        view.currentPrice.text = product.preco.precoAtual.brazilCurrency()
        view.setOnClickListener {
            navigatoToActivity(
                context = view.context,
                activity = DetailActivity::class.java,
                key = product.id
            )
        }

        Glide.with(view)
            .load(product.imagemUrl)
            .error(R.drawable.error_image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view.productImage)
    }

}