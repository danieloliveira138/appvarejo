package com.danieloliveira.viavarejo.models

data class DetailData(
    var detail: ProductDetail = ProductDetail(),
    var other: List<OtherProduct> = listOf()
)