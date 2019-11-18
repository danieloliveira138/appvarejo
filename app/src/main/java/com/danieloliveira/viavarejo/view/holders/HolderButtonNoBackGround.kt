package com.danieloliveira.viavarejo.view.holders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.holder_button_no_background.view.*

class HolderButtonNoBackGround(private val view: View): RecyclerView.ViewHolder(view), IBaseHolder {
    override fun bind(data: Any) {
        view.buttonBuy.setOnClickListener {
            Toast.makeText(view.context,
                            "Impossível realizar esta compra no momento",
                            Toast.LENGTH_SHORT).show()
        }
    }

}