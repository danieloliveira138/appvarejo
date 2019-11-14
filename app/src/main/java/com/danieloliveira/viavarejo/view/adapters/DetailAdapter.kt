package com.danieloliveira.viavarejo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.enums.DetailAdapterViewType
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.view.holders.*

class DetailAdapter(private val productDetail: ProductDetail,
                    private val fragmentManager: FragmentManager?)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var expandDescriptionHolder = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view: View

        when (viewType) {
            DetailAdapterViewType.PRODUCT_IMAGE.type -> {
                view =  inflater.inflate(R.layout.view_pager_layout, parent, false)
                return HolderBaseImage(view)
            }
            DetailAdapterViewType.PRODUCT_TITLE.type -> {
                view =  inflater.inflate(R.layout.product_title, parent, false)
                return HolderTitle(view)
            }
            DetailAdapterViewType.BUY_BUTTON.type -> {
                view =  inflater.inflate(R.layout.holder_button_buy, parent, false)
                return HolderButton(view)
            }
            DetailAdapterViewType.PRODUCT_FEATURES.type -> {
                view =  inflater.inflate(R.layout.holder_description, parent, false)
                return HoldeDescription(view)
            }
            DetailAdapterViewType.PRODUCT_AVALIATION.type -> {
                view =  inflater.inflate(R.layout.holder_rating, parent, false)
                return HolderRating(view)
            }
            DetailAdapterViewType.WHO_SAW_BOUGHT.type -> {
                view =  inflater.inflate(R.layout.holder_horizontal_list, parent, false)
                return HolderWhoSawBought(view)
            }
            DetailAdapterViewType.SECOND_BUY_BUTTON.type -> {
                view =  inflater.inflate(R.layout.holder_button_no_background, parent, false)
                return HolderButtonNoBackGround(view)
            }
            else -> {
                view =  inflater.inflate(R.layout.view_pager_layout, parent, false)
                return HolderBaseImage(view)
            }
        }
    }

    override fun getItemCount(): Int = 7

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as IBaseHolder
        when (position) {
            DetailAdapterViewType.PRODUCT_IMAGE.type -> {
                holder.bind(HolderBaseImage.ImageHolderData(
                    fragmentManager, productDetail.modelo.padrao.imagens
                ))
            }
            DetailAdapterViewType.PRODUCT_TITLE.type -> {
                holder.bind(productDetail)
            }
            DetailAdapterViewType.BUY_BUTTON.type -> {
                holder.bind(productDetail.id)
            }
            DetailAdapterViewType.PRODUCT_FEATURES.type -> {
                holder as HoldeDescription
                holder.bind(
                    HolderDescriptionData(productDetail.maisInformacoes[0], expandDescriptionHolder)
                )
                holder.itemView.setOnClickListener {
                    holder.bind(
                        HolderDescriptionData(productDetail.maisInformacoes[0], expandDescriptionHolder)
                    )
                    notifyItemChanged(DetailAdapterViewType.PRODUCT_FEATURES.type)
                    expandDescriptionHolder = !expandDescriptionHolder
                }
            }
            DetailAdapterViewType.PRODUCT_AVALIATION.type -> {
                holder.bind(Any())
            }
            DetailAdapterViewType.WHO_SAW_BOUGHT.type -> {
                holder.bind(Any())
            }
            DetailAdapterViewType.SECOND_BUY_BUTTON.type -> {
                holder.bind(productDetail.id)
            }
            else -> {

            }

        }


    }

    override fun getItemViewType(position: Int): Int = position

}