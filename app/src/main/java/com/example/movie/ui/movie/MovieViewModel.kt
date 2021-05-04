package com.example.movie.ui.movie

import androidx.lifecycle.ViewModel
import com.example.movie.data.Entity
import com.example.movie.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies() : List<Entity> = DataDummy.generateDummyMovies()
}