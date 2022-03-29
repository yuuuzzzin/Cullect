package com.example.networkpractice.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.networkpractice.R
import com.example.networkpractice.util.ResUtil.getDrawable
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("url")
    fun setImageViewUrl(view: AppCompatImageView, url: String?) {
        url?.let {
            Glide.with(view.context).load(it)
                .placeholder(shimmerDrawable)
                .error(getDrawable(R.drawable.img_null))
                .into(view)
        }
    }
}