package com.danieloliveira.viavarejo.view.holders

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import kotlinx.android.synthetic.main.holder_button_buy.view.*

class HolderButton(private val view: View): RecyclerView.ViewHolder(view), IBaseHolder {
    override fun bind(data: Any) {
        if (data is Boolean) {
            view.buttonBuyBackground.setBackgroundColor(ContextCompat.getColor(view.context, R.color.light_grey))
        }
        view.buttonBuy.setOnClickListener {
            Toast.makeText(
                view.context,
                "No momento é impossível realizar esta compra",
                Toast.LENGTH_SHORT).show()
        }
    }

}