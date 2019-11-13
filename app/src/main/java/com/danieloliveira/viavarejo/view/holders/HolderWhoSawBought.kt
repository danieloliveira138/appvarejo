package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.textview_holder_title.view.*

class HolderWhoSawBought(private val view: View): RecyclerView.ViewHolder(view), IBaseHolder {
    override fun bind(data: Any) {
        view.title.text = String.format("Quem viu Comprou")
    }

}