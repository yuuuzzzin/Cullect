package com.example.networkpractice.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.networkpractice.R
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("url")
    fun setImageViewUrl(view: AppCompatImageView, url: String?) {

        val shimmer: Shimmer = Shimmer.ColorHighlightBuilder()
            .setBaseAlpha(0.8f)
            .setHighlightAlpha(0.9f)
            .setDuration(1800)
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()

        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }

        url?.let {
            Glide.with(view.context).load(it)
                .placeholder(shimmerDrawable)
                .error(ContextCompat.getDrawable(view.context, R.drawable.img_null))
                .into(view)
        }
    }
}