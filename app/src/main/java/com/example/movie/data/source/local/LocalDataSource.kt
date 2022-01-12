package com.example.movie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.local.room.Dao

class LocalDataSource private constructor(private val mDao:Dao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dao:Dao):LocalDataSource =
            INSTANCE ?: LocalDataSource(dao)
    }

//    fun getAllMovies(): LiveData<List<Entity>> = mDao.getAllMovies()

    fun getAllMovies(): DataSource.Factory<Int, Entity> = mDao.getAllMovies()

//    fun getAllShows(): LiveData<List<Entity>> = mDao.getAllShows()

    fun getAllShows(): DataSource.Factory<Int, Entity> = mDao.getAllShows()

    fun getDetails(id:String,title:String) : LiveData<Entity> = mDao.getDetail(id, title)

    fun insertData(data : List<Entity>) = mDao.insertData(data)

    fun setLikedData(entity: Entity,newState: Boolean) {
        entity.liked = newState
        mDao.updateData(entity)
    }

    fun getLikedMovies(): DataSource.Factory<Int, Entity> = mDao.geLikedMovies()

    fun getLikedShows(): DataSource.Factory<Int, Entity> = mDao.getLikedShows()


}