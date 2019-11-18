package com.danieloliveira.viavarejo.models

data class Lojista(
    val compraOnline: Boolean = false,
    val eleito: Boolean = false,
    val id: Int = 0,
    val nome: String = "",
    val preco: Int = 0,
    val retiraRapido: Boolean = false
)