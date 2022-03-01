package com.lucasdonato.rickandmortyapi.data.remote

import com.lucasdonato.rickandmortyapi.data.model.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): ResponseApi

}