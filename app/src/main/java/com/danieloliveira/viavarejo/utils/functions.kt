package com.danieloliveira.viavarejo.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

fun getJsonFile(pathId: Int, context: Context) : String =
    context.resources.openRawResource(pathId)
        .bufferedReader().use {
            it.readText()
        }

fun <T> navigatoToActivity(context: Context, activity: Class<T>, key: Int = -1) {
    val intent = Intent(context, activity)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    if (key != -1) intent.putExtra("ddsf", key)
    context.startActivity(intent)
}