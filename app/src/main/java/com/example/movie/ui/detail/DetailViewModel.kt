package com.example.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.Repository

class DetailViewModel(private val repository: Repository): ViewModel() {
    private lateinit var id : String
    private lateinit var title : String
    var id2 = MutableLiveData<String>()

    fun setSelectedCourse(id: String,title: String) {
        this.id = id
        this.title = title
        this.id2.value = id
    }

    var dataRepository: LiveData<Entity> = Transformations.switchMap(id2) { mId ->
        repository.getDetail(id, title)
    }

    fun getData() :LiveData<Entity> = repository.getDetail(id,title)

    fun setLiked(){
        val entity = dataRepository.value
        if (entity != null){
            val newState = !entity.liked
            repository.setDataLiked(entity,newState)
        }

    }

}