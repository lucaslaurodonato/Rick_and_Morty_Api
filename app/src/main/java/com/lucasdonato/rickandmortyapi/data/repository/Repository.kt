package com.lucasdonato.rickandmortyapi.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucasdonato.rickandmortyapi.data.local.FavoritesDatabase
import com.lucasdonato.rickandmortyapi.data.model.RickAndMorty
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity
import com.lucasdonato.rickandmortyapi.data.paging.RickyMortyPagingSource
import com.lucasdonato.rickandmortyapi.data.remote.WebService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val webService: WebService
) {

    fun getAllCharacters(): Flow<PagingData<RickAndMorty>> {
        return Pager(config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { RickyMortyPagingSource(webService) }).flow
    }

}