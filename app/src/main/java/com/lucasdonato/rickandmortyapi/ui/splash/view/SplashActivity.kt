package com.lucasdonato.rickandmortyapi.ui.splash.view

import android.os.Bundle
import android.os.Handler
import androidx.paging.ExperimentalPagingApi
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.databinding.ActivitySplashBinding
import com.lucasdonato.rickandmortyapi.ui.home.view.HomeActivity
import com.lucasdonato.rickandmortyapi.utils.base.BaseActivity

import com.lucasdonato.rickandmortyapi.utils.constants.Constants.SPLASH_DISPLAY_TIME

@ExperimentalPagingApi
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startHomeScreen()
        }, SPLASH_DISPLAY_TIME.toLong())
    }

    private fun startHomeScreen() {
        startActivity(HomeActivity.getStartIntent(this))
        finish()
    }

}