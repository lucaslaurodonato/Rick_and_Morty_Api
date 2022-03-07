package com.lucasdonato.rickandmortyapi.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lucasdonato.rickandmortyapi.data.model.RickAndMorty
import com.lucasdonato.rickandmortyapi.data.remote.WebService

class RickyMortyPagingSource(private val webService: WebService) : PagingSource<Int, RickAndMorty>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMorty> {

        val currentPage = params.key ?: 1

        return try {
            val response = webService.getAllCharacters(currentPage)
            val endOfPaginationReached = response.results.isEmpty()
            if (response.results.isNotEmpty()) {
                LoadResult.Page(
                    data = response.results,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(), prevKey = null, nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RickAndMorty>): Int? {
        return state.anchorPosition
    }

}