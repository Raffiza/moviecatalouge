package com.example.movie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.vo.Resource

interface DataSource {

    fun getAllMovies() : LiveData<Resource<PagedList<Entity>>>

    fun getAllShow() : LiveData<Resource<PagedList<Entity>>>

    fun getDetail(id : String, title: String) : LiveData<Entity>

    fun setDataLiked(data: Entity,state: Boolean)

    fun getMovieLiked() : LiveData<PagedList<Entity>>

    fun getShowLiked() : LiveData<PagedList<Entity>>

}