package com.danieloliveira.viavarejo.models

data class Padrao(
    val disponivel: Boolean = false,
    val imagens: List<Imagen> = listOf(),
    val marketplace: Marketplace = Marketplace(),
    val nome: String = "",
    val preco: Preco = Preco(),
    val servicos: List<Servico> = listOf(),
    val sku: Int = 0
)