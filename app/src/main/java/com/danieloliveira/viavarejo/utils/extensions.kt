package com.danieloliveira.viavarejo.utils

import android.graphics.Paint
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

fun TextView.strike(text: String) {
    this.text = text
    this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun Double.brazilCurrency(): String {
    return try {
        NumberFormat
            .getCurrencyInstance(Locale("pt", "BR")).format(this)
    } catch (e: Exception) {
        "#ERROR#"
    }
}
fun String.brazilCurrency(): String {
    return try {
        NumberFormat
            .getCurrencyInstance(Locale("pt", "BR")).format(this.toDouble())
    } catch (e: Exception) {
        "#ERROR#"
    }
}