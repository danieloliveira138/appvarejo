package com.danieloliveira.viavarejo.utils

import android.graphics.Paint
import android.widget.TextView

fun TextView.strike(text: String) {
    this.text = text
    this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}