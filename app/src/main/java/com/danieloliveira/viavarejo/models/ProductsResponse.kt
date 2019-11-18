package com.danieloliveira.viavarejo.models

data class ProductsResponse(
    val produtos: List<Produto> = listOf(),
    val quantidade: Int = 0
)