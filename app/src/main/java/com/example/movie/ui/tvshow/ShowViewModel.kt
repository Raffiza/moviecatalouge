package com.example.movie.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.movie.data.Entity
import com.example.movie.utils.DataDummy

class ShowViewModel : ViewModel() {
    fun getShows(): List<Entity> = DataDummy.generateDummyShows()
}