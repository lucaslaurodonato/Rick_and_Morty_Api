package com.lucasdonato.rickandmortyapi.utils.bindingadapter

import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.utils.constants.Constants
import com.lucasdonato.rickandmortyapi.utils.extensions.setTint

@BindingAdapter("setVisibility")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url).into(view)
}

@BindingAdapter("changeColor")
fun changeColorDot(view: ImageView, status: String) {
    when (status) {
        Constants.ALIVE -> view.setTint(R.color.stats_green)
        Constants.DEAD -> view.setTint(R.color.stats_red)
        Constants.UNKNOWN -> view.setTint(R.color.stats_gray)
    }
}


