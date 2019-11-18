package com.danieloliveira.viavarejo.models

data class OtherProduct(
    val classificacao: Double = 0.0,
    val id: Int = 0,
    val imagemUrl: String = "",
    val nome: String = "",
    val parcelamento: String = "",
    val percentualCompra: Double = 0.0,
    val precoAnterior: Double = 0.0,
    val precoAtual: Double = 0.0,
    val sku: Int = 0
)