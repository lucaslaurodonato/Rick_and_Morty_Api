package com.lucasdonato.rickandmortyapi.data.repository

import com.lucasdonato.rickandmortyapi.data.local.FavoritesDatabase
import com.lucasdonato.rickandmortyapi.data.model.RickAndMorty
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity
import javax.inject.Inject

class RepositoryDataBase @Inject constructor(
    private val database: FavoritesDatabase
) {
    suspend fun addOnDatabase(rickAndMorty: RickAndMorty) {
        val rickAndMortyEntity = RickAndMortyEntity(
            id = rickAndMorty.id,
            name = rickAndMorty.name,
            image = rickAndMorty.image,
            species = rickAndMorty.species,
            gender = rickAndMorty.gender,
            status = rickAndMorty.status
        )
        database.favoritesDao.insert(rickAndMortyEntity)
    }

    suspend fun deleteOnDatabase(id: Int) {
        database.favoritesDao.delete(id)
    }

    suspend fun getAllFavorites(): MutableList<RickAndMortyEntity> {
        return database.favoritesDao.getAll().toMutableList()
    }
}