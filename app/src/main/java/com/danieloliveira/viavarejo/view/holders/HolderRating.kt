package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.holder_description_detail.view.*
import kotlinx.android.synthetic.main.textview_holder_title.view.*

class HolderRating(private val view: View): RecyclerView.ViewHolder(view), IProductHolder {
    override fun bind(data: Any) {
        view.title.text = String.format("Avaliações")
        view.name.text = String.format("Alexandre")
        view.value.text = String.format("Produto Maravilhoso!!!")
        view.divider.visibility = View.GONE
    }
}