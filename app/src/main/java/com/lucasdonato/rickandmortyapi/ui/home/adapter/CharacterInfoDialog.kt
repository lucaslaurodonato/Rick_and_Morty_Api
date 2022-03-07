package com.lucasdonato.rickandmortyapi.ui.home.adapter

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity

import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.data.model.RickMorty
import com.lucasdonato.rickandmortyapi.databinding.CharacterInfoDialogBinding
import com.lucasdonato.rickandmortyapi.utils.constants.Constants
import com.lucasdonato.rickandmortyapi.utils.extensions.setTint

class CharacterInfoDialog(owner: Context, val rickMorty: RickMorty) : Dialog(owner) {

    val binding: CharacterInfoDialogBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.character_info_dialog, null, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rickAndMorty = rickMorty

        val lp = WindowManager.LayoutParams()
        lp.apply {
            this@CharacterInfoDialog.window?.let {
                copyFrom(it.attributes)
            }
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.WRAP_CONTENT
            gravity = Gravity.CENTER
        }

        this.window?.let {
            it.setBackgroundDrawableResource(android.R.color.transparent)
            it.attributes = lp
            it.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        }
    }
}
