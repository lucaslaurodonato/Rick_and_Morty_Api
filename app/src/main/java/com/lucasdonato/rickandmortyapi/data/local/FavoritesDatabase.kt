package com.lucasdonato.rickandmortyapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity

@Database(entities = [RickAndMortyEntity::class], version = 1)
abstract class FavoritesDatabase : RoomDatabase() {

    abstract val favoritesDao : FavoritesDao

}