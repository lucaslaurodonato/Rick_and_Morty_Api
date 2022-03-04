package com.lucasdonato.rickandmortyapi.ui.details.view

import android.os.Bundle
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.databinding.ActivityDetailsBinding
import com.lucasdonato.rickandmortyapi.utils.base.BaseActivity

class DetailsActivity : BaseActivity<ActivityDetailsBinding>(R.layout.activity_details) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }

}