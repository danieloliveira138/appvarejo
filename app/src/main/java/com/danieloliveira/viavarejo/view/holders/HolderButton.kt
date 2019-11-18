package com.danieloliveira.viavarejo.view.holders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.holder_button_buy.view.*

class HolderButton(private val view: View): RecyclerView.ViewHolder(view), IBaseHolder {
    override fun bind(data: Any) {
        view.buttonBuy.setOnClickListener {
            Toast.makeText(
                view.context,
                "No momento é impossível realizar esta compra",
                Toast.LENGTH_SHORT).show()
        }
    }

}