package com.danieloliveira.viavarejo.models

data class Modelo(
    val padrao: Padrao = Padrao(),
    val skus: List<Any> = listOf()
)