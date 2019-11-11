package com.danieloliveira.viavarejo.models

data class DescontoFormaPagamento(
    val descricao: Any = Any(),
    val porcentagemDesconto: Int = 0,
    val possuiDesconto: Boolean = false,
    val preco: Int = 0
)