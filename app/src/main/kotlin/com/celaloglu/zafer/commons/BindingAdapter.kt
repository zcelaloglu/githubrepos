package com.celaloglu.zafer.commons

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.celaloglu.zafer.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadUrl")
    fun setImageUrl(view: ImageView, imgSrc: String?) {
        imgSrc?.let {
            Glide.with(view.context)
                .load(imgSrc)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible)
            view.visibility = View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

}