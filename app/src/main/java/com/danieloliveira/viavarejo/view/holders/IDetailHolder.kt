package com.danieloliveira.viavarejo.view.holders

import com.danieloliveira.viavarejo.models.ProductDetail

interface IDetailHolder {
    fun bind(productDetail: ProductDetail)
}