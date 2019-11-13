package com.danieloliveira.viavarejo.models

data class Marketplace(
    val lojistaPadrao: Lojista = Lojista(),
    val lojistasEmDestaque: List<Lojista> = listOf(),
    val maiorPreco: Int = 0,
    val menorPreco: Int = 0
)