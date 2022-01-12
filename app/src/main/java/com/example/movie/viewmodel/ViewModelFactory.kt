package com.example.movie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.source.Repository
import com.example.movie.di.Injection
import com.example.movie.ui.detail.DetailViewModel
import com.example.movie.ui.movie.LikedMovieViewModel
import com.example.movie.ui.movie.MovieViewModel
import com.example.movie.ui.tvshow.LikedShowViewModel
import com.example.movie.ui.tvshow.ShowViewModel

class ViewModelFactory private constructor(private val repository : Repository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context:Context) : ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ShowViewModel::class.java) -> {
                return ShowViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LikedMovieViewModel::class.java) -> {
                return LikedMovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LikedShowViewModel::class.java) -> {
                return LikedShowViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}