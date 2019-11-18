package com.danieloliveira.viavarejo.models

data class ProductDetail(
    val categorias: List<Categoria> = listOf(),
    val descricao: String = "",
    val id: Int = 0,
    val maisInformacoes: List<MaisInformacoe> = listOf(),
    val marca: Marca = Marca(),
    val modelo: Modelo = Modelo(),
    val nome: String = "",
    val retiraEmLoja: Boolean = false,
    val urlVideo: Any = Any()
)