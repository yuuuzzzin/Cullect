package com.example.networkpractice.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.networkpractice.R
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import jp.wasabeef.glide.transformations.BlurTransformation




object BindingAdapters {

    @JvmStatic
    @BindingAdapter("url")
    fun setImageViewUrl(view: AppCompatImageView, url: String?) {
        url?.let {
            Glide.with(view.context).load(it)
                .error(ContextCompat.getDrawable(view.context, R.drawable.img_null))
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("urlWithShimmer")
    fun setImageViewUrlWithShimmer(view: AppCompatImageView, url: String?) {

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

    @JvmStatic
    @BindingAdapter("blurUrl")
    fun setBlurredImageViewUrl(view: AppCompatImageView, url: String?) {
        url?.let {
            Glide.with(view.context).load(it)
                .error(ContextCompat.getDrawable(view.context, R.drawable.img_null))
                .transform(BlurTransformation(24))
                .into(view)
        }
    }
}