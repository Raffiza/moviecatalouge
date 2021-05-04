package com.example.movie.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movie.data.Entity
import com.example.movie.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var id : String

    fun setSelectedCourse(id: String) {
        this.id = id
    }

    fun getData() : Entity {
        lateinit var data: Entity
        val moviesEntities = DataDummy.generateDummyMovies()
        val showEntities = DataDummy.generateDummyShows()
        for (movieEntity in moviesEntities) {
            if (movieEntity.Id == id) {
                data = movieEntity
            }
        }

        for (showEntity in showEntities) {
            if (showEntity.Id == id) {
                data = showEntity
            }
        }
        return data
    }

}