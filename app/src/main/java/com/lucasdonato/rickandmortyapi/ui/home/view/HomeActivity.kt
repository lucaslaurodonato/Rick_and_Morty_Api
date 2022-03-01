package com.lucasdonato.rickandmortyapi.ui.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.databinding.ActivityMainBinding
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter
import com.lucasdonato.rickandmortyapi.ui.home.viewmodel.HomeViewModel
import com.lucasdonato.rickandmortyapi.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

@ExperimentalPagingApi
@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        loadData()
        closeApp()
    }

    private fun setupRecyclerView() {
        binding.adapter = CharacterAdapter()
    }

    private fun closeApp() {
        binding.include.activity = this
    }

    private fun loadData() = lifecycleScope.launch {
        viewModel.getAll.collectLatest { pagingData ->
            binding.adapter?.submitData(pagingData)
        }
    }

}