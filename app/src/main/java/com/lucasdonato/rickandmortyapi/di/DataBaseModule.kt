package com.lucasdonato.rickandmortyapi.di

import android.content.Context
import androidx.room.Room
import com.lucasdonato.rickandmortyapi.data.local.FavoritesDatabase
import com.lucasdonato.rickandmortyapi.utils.constants.Constants.RICK_AND_MORTY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): FavoritesDatabase {
        return Room.databaseBuilder(context, FavoritesDatabase::class.java, RICK_AND_MORTY_DATABASE)
            .build()
    }

}