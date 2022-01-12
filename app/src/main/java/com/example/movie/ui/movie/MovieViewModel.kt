package com.example.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.Repository
import com.example.movie.vo.Resource

class MovieViewModel (private val repository : Repository): ViewModel() {
    fun getMovies() : LiveData<Resource<PagedList<Entity>>> = repository.getAllMovies()
}