package com.example.movie.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.movie.data.source.Repository
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LikedMovieViewModelTest {

    private lateinit var viewModel: LikedMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<PagedList<Entity>>

    @Mock
    private lateinit var pagedList: PagedList<Entity>

    @Before
    fun setUp(){
        viewModel = LikedMovieViewModel(repository)
    }

    @Test
    fun getLikedMovies() {
        val dummyMovies = pagedList
        val movies = MutableLiveData<PagedList<Entity>>()
        movies.value = dummyMovies

        `when`(repository.getMovieLiked()).thenReturn(movies)
        val entities = viewModel.getLikedMovies().value
        verify(repository).getMovieLiked()
        Assert.assertNotNull(entities)

        viewModel.getLikedMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}