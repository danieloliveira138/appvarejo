package com.danieloliveira.viavarejo.utils

import android.graphics.Paint
import android.widget.TextView
import com.danieloliveira.viavarejo.models.Preco
import com.danieloliveira.viavarejo.models.OtherProduct
import com.danieloliveira.viavarejo.models.Produto
import java.text.NumberFormat
import java.util.*

fun TextView.strike(text: String) {
    this.text = text
    this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun Double.brazilCurrency(): String {
    return try {
        NumberFormat
            .getCurrencyInstance(Locale("pt", "BR")).format(this)
    } catch (e: Exception) {
        "#ERROR#"
    }
}

fun Any.isListProductsResponse(): Boolean =
    this is List<*> && this.isNotEmpty() && this[0] is OtherProduct

fun Any.isListProduto(): Boolean =
    this is List<*> && !this.isNullOrEmpty() && this[0] is Produto

fun Any.castToListProduto(): List<Produto> {
    if (this.isListProduto()) {
        return this as List<Produto>
    }

    return if (this.isListProductsResponse()) {
        val list = this.castToListProductosResponse()
        list.toProdutoList()
    } else
        listOf()
}

fun Any.castToListProductosResponse(): List<OtherProduct> {
    if (this.isListProductsResponse()) {
        return this as List<OtherProduct>
    }

    return listOf()
}

fun OtherProduct.toProduto() =
    Produto(
        id = this.id,
        classificacao = this.classificacao,
        nome = this.nome,
        sku = this.sku,
        imagemUrl = this.imagemUrl,
        preco = Preco(
            precoAtual = this.precoAtual,
            precoAnterior = this.precoAnterior
        )
    )

fun List<OtherProduct>.toProdutoList(): List<Produto> {
    if (this.isNullOrEmpty()) return listOf()

    return this.map { it.toProduto() }
}