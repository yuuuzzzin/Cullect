package com.example.networkpractice.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("url")
    fun setImageViewUrl(view: AppCompatImageView, url: String?) {
        url?.let {
            Glide.with(view.context).load(it).into(view)
        }
    }
}