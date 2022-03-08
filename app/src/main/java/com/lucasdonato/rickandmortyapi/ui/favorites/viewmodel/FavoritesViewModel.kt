package com.lucasdonato.rickandmortyapi.ui.favorites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity
import com.lucasdonato.rickandmortyapi.data.repository.RepositoryDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: RepositoryDataBase) :
    ViewModel() {

    private var _getAllFavorites = MutableLiveData<MutableList<RickAndMortyEntity>>()
    val getAllFavorites: LiveData<MutableList<RickAndMortyEntity>> get() = _getAllFavorites

    fun getAllFavorites() = viewModelScope.launch {
        _getAllFavorites.postValue(repository.getAllFavorites())
    }

    fun deleteFavorite(id: Int) = viewModelScope.launch {
        repository.deleteOnDatabase(id)
    }

}