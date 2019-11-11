package com.danieloliveira.viavarejo.models

data class Marketplace(
    val lojistaPadrao: LojistaPadrao = LojistaPadrao(),
    val lojistasEmDestaque: List<LojistasEmDestaque> = listOf(),
    val maiorPreco: Int = 0,
    val menorPreco: Int = 0
)