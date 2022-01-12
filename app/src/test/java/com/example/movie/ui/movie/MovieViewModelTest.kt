package com.example.movie.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.Repository
import com.example.movie.utils.DataDummy
import com.example.movie.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Entity>>>

    @Mock
    private lateinit var pagedList: PagedList<Entity>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<Entity>>>()
        movies.value = dummyMovies

        `when`(repository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value?.data
        verify(repository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(5,movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}