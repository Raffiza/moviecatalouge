package com.example.movie.di

import android.content.Context
import com.example.movie.data.source.Repository
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.room.DataDatabase
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.utils.AppExecutors
import com.example.movie.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): Repository {

        val database = DataDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.dao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}