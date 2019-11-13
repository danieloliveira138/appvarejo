package com.danieloliveira.viavarejo.view.holders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.models.ProductDetail
import com.danieloliveira.viavarejo.utils.brazilCurrency
import com.danieloliveira.viavarejo.utils.strike
import kotlinx.android.synthetic.main.product_title.view.*

class HolderTitle(private val view: View): RecyclerView.ViewHolder(view), IProductHolder {
    override fun bind(data: Any) {
        if (data is ProductDetail) {
            view.title.text = data.nome
            view.description.text = data.descricao
            view.previousPrice.strike(data.modelo.padrao.preco.precoAnterior.brazilCurrency())
            view.currentPrice.text = data.modelo.padrao.preco.precoAtual.brazilCurrency()
            view.specialCondition.text = data.modelo.padrao.preco.planoPagamento
            view.seeSpecialCondition.text = String.format("ver parcelamento")
            view.seeSpecialCondition.setOnClickListener {
                Toast.makeText(
                    view.context,
                    "Impossível obter as informações de parcelamento neste momento",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}