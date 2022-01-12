package com.example.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movie.data.source.Repository
import com.example.movie.data.source.local.entity.Entity

class LikedMovieViewModel(private val repository : Repository): ViewModel() {
    fun getLikedMovies() : LiveData<PagedList<Entity>> = repository.getMovieLiked()

    fun setLiked(entity: Entity){
        val newState = !entity.liked
        repository.setDataLiked(entity,newState)
    }
}