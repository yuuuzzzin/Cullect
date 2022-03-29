package com.example.networkpractice.util

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.networkpractice.R
import com.example.networkpractice.util.ResUtil.getColor
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.google.android.material.snackbar.Snackbar
import java.net.URLDecoder

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun defaultSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        .show()
}

fun decode(str: String): String = URLDecoder.decode(str, "UTF-8")