package com.lucasdonato.rickandmortyapi.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lucasdonato.rickandmortyapi.data.model.RickMorty
import com.lucasdonato.rickandmortyapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        getAllCharacters()
    }

    private val _getAll = MutableStateFlow<PagingData<RickMorty>>(PagingData.empty())
    val getAll = _getAll

    private fun getAllCharacters() = viewModelScope.launch {
        repository.getAllCharacters().cachedIn(viewModelScope).collect {
            _getAll.value = it
        }
    }

}