package com.yuuuzzzin.recordnize.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.net.URLDecoder
import kotlin.math.roundToInt

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun defaultSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        .show()
}

fun convertDPtoPX(context: Context, dp: Int): Int {
    val density: Float = context.resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}

fun convertPXtoDP(context: Context, px: Int): Int {
    val density: Float = context.resources.displayMetrics.density
    return (px.toFloat() / density).roundToInt()
}

fun decode(str: String): String = URLDecoder.decode(str, "UTF-8")
