package com.danieloliveira.viavarejo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.enums.DetailAdapterViewType
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.view.holders.HolderProductImage

class DetailAdapter(private val productDetail: ProductDetail)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view: View

        when (viewType) {
            DetailAdapterViewType.PRODUCT_IMAGE.type -> {
                view =  inflater.inflate(R.layout.holder_product_image, parent, false)
                return HolderProductImage(view)
            }
            DetailAdapterViewType.PRODUCT_TITLE.type -> {

            }
            DetailAdapterViewType.PRODUCT_PRICE.type -> {
            }
            DetailAdapterViewType.BUY_BUTTON.type -> {
            }
            DetailAdapterViewType.PRODUCT_FEATURES.type -> {
            }
            DetailAdapterViewType.PRODUCT_AVALIATION.type -> {
            }
            DetailAdapterViewType.WHO_SAW_BOUGHT.type -> {
            }
            DetailAdapterViewType.SECOND_BUY_BUTTON.type -> {
            }
            else -> {

            }
        }
    }

    override fun getItemCount(): Int = 7

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemViewType(position: Int): Int = position

}