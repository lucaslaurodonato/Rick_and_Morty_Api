package com.lucasdonato.rickandmortyapi.ui.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.databinding.ActivityHomeBinding
import com.lucasdonato.rickandmortyapi.ui.favorites.view.FavoritesActivity
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter
import com.lucasdonato.rickandmortyapi.ui.home.viewmodel.HomeViewModel
import com.lucasdonato.rickandmortyapi.utils.base.BaseActivity
import com.lucasdonato.rickandmortyapi.utils.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        loadData()
        startFavorites()
    }

    private fun setupRecyclerView() {
        binding.adapter = CharacterAdapter { item, _ ->
            viewModel.addOnFavorites(item)
            toast(getString(R.string.add_on_favorites))
        }
    }

    private fun loadData() = lifecycleScope.launch {
        viewModel.getAll.collectLatest { pagingData ->
            binding.adapter?.submitData(pagingData)
        }
    }

    private fun startFavorites() {
        binding.incToolbar.ivFavorites.setOnClickListener {
            startActivity(FavoritesActivity.getStartIntent(this))
        }
    }

}