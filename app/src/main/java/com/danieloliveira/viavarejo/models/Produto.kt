package com.danieloliveira.viavarejo.models

data class Produto(
    val classificacao: Int = 0,
    val descricao: String = "",
    val disponivel: Boolean = false,
    val id: Int = 0,
    val imagemUrl: String = "",
    val nome: String = "",
    val preco: Preco = Preco(),
    val sku: Int = 0
)