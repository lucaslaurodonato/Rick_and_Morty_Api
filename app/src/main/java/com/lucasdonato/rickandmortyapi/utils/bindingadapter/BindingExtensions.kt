package com.lucasdonato.rickandmortyapi.utils.bindingadapter

import android.view.View
import android.view.View.*
import androidx.databinding.BindingAdapter

@BindingAdapter("setVisibility")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}