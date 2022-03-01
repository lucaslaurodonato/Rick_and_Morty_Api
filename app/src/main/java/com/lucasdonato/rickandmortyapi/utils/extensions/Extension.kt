package com.lucasdonato.rickandmortyapi.utils.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast

fun Activity.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun View.toast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()




