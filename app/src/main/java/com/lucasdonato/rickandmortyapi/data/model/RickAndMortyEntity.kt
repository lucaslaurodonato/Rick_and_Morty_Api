package com.lucasdonato.rickandmortyapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RickAndMortyEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val gender: String
)