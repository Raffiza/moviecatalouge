package com.example.movie.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.Repository
import com.example.movie.vo.Resource

class ShowViewModel(private val repository : Repository) : ViewModel() {
    fun getShows(): LiveData<Resource<PagedList<Entity>>> = repository.getAllShow()
}