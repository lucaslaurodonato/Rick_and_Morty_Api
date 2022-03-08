package com.lucasdonato.rickandmortyapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rickAndMortyEntity: RickAndMortyEntity)

    @Query("DELETE FROM rickAndMortyEntity WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM rickAndMortyEntity")
    suspend fun getAll(): List<RickAndMortyEntity>

}