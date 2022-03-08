package com.lucasdonato.rickandmortyapi.ui.favorites.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.paging.ExperimentalPagingApi
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity
import com.lucasdonato.rickandmortyapi.databinding.ActivityFavoritesBinding
import com.lucasdonato.rickandmortyapi.ui.favorites.adapter.FavoritesCharactersAdapter
import com.lucasdonato.rickandmortyapi.ui.favorites.viewmodel.FavoritesViewModel
import com.lucasdonato.rickandmortyapi.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesActivity : BaseActivity<ActivityFavoritesBinding>(R.layout.activity_favorites) {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, FavoritesActivity::class.java)
    }

    private val viewModel: FavoritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllFavorites()
        binding.activity = this
        observer()
    }

    private fun observer() {
        viewModel.getAllFavorites.observe(this) {
            setupRecycler(it)
        }
    }

    private fun setupRecycler(listFavorites: MutableList<RickAndMortyEntity>) {
        if (listFavorites.isEmpty()) binding.emptyVisible = true
        binding.adapter = FavoritesCharactersAdapter(listFavorites) { item, _ ->
            viewModel.deleteFavorite(item.id)
        }
    }

}