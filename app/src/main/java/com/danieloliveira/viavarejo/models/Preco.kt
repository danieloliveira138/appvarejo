package com.danieloliveira.viavarejo.models

data class Preco(
    val descontoFormaPagamento: DescontoFormaPagamento = DescontoFormaPagamento(),
    val planoPagamento: String = "",
    val porcentagemDesconto: Int = 0,
    val precoAnterior: Double = 0.0,
    val precoAtual: Int = 0,
    val quantidadeMaximaParcelas: Int = 0,
    val valorParcela: Double = 0.0
)