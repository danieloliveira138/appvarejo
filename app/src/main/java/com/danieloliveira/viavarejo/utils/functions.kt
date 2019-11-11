package com.danieloliveira.viavarejo.utils

import android.content.Context

fun getJsonFile(pathId: Int, context: Context) : String =
    context.resources.openRawResource(pathId)
        .bufferedReader().use {
            it.readText()
        }