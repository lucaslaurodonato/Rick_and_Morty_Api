package com.lucasdonato.rickandmortyapi.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lucasdonato.rickandmortyapi.data.model.RickMorty
import com.lucasdonato.rickandmortyapi.data.remote.WebService

class RickyMortyPagingSource(private val webService: WebService) : PagingSource<Int, RickMorty>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMorty> {

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

        //        return try {
        //            val currentPage = params.key ?: 1
        //            val response = apiService.getAllCharacters(currentPage)
        //            val responseData = mutableListOf<RickMorty>()
        //            val data = response.body()?.results ?: emptyList()
        //            responseData.addAll(data)
        //
        //            LoadResult.Page(
        //                data = responseData,
        //                prevKey = if (currentPage == 1) null else -1,
        //                nextKey = currentPage.plus(1)
        //            )
        //        } catch (e: Exception) {
        //            LoadResult.Error(e)
        //        }
    }

    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {
        return state.anchorPosition
    }

}