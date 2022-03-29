package com.example.networkpractice.util

import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.networkpractice.BaseApplication

object ResUtil {

    fun getColor(@ColorRes id: Int): Int = ContextCompat.getColor(BaseApplication.appCtx(), id)
    fun getString(@StringRes id: Int): String = BaseApplication.appCtx().getString(id)
    fun getDrawable(@DrawableRes id: Int): Drawable? =
        ContextCompat.getDrawable(BaseApplication.appCtx(), id)
    fun getStringArray(@ArrayRes id: Int): Array<String> =
        BaseApplication.appCtx().resources.getStringArray(id)
}