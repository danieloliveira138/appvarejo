package com.danieloliveira.viavarejo.view.holders

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.MaisInformacoe
import com.danieloliveira.viavarejo.models.Valore
import kotlinx.android.synthetic.main.holder_description.view.*
import kotlinx.android.synthetic.main.textview_holder_title.view.*

class HoldeDescription(private val view: View): RecyclerView.ViewHolder(view), IProductHolder {

    override fun bind(data: Any) {
        if(data is HolderDescriptionData) {
            view.title.text = data.maisInformacoe.descricao
            view.valuesList.removeAllViews()
            createListDescription(data.maisInformacoe.valores, data.expanded)
        }
    }

    private fun createListDescription(valores: List<Valore>, enabled: Boolean) {
        var list = valores

        if(enabled) {
            list = valores.subList(0, 2)
        }

        for (index in list.indices) {
            val inflator = LayoutInflater.from(view.context)
            val view = inflator.inflate(
                R.layout.holder_description_detail,
                view.valuesList,
                false)
            val holder = HolderDescriptionDetail(view)
            holder.bind(list[index])

            if (index == list.lastIndex)
                holder.hideDivider(enabled = false)

            this.view.valuesList.addView(holder.itemView)
        }
    }
}

data class HolderDescriptionData(
    val maisInformacoe: MaisInformacoe,
    val expanded: Boolean
)