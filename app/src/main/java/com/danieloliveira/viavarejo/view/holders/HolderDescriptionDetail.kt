package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.models.Valore
import kotlinx.android.synthetic.main.holder_description_detail.view.*

class HolderDescriptionDetail(private val view: View): RecyclerView.ViewHolder(view), IProductHolder {
    override fun bind(data: Any) {
        if (data is Valore) {
            view.name.text = data.nome
            view.value.text = data.valor.capitalize()
        }
    }

    fun hideDivider(enabled: Boolean) {
        view.divider.visibility = if (enabled) View.VISIBLE else View.GONE
    }
}