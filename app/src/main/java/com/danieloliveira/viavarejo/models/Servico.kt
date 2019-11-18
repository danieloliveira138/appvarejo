package com.danieloliveira.viavarejo.models

data class Servico(
    val idLojista: Int = 0,
    val nome: String = "",
    val parcelamento: String = "",
    val preco: Int = 0,
    val sku: Int = 0,
    val tipo: String = ""
)