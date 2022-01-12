package com.example.movie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.Repository
import com.example.movie.utils.DataDummy
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
 class DetailViewModelTest {

    private lateinit var movieDetailVewModel: DetailViewModel
    private lateinit var showDetailViewlModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyShows = DataDummy.generateDummyShows()[0]

    private val movieId = dummyMovie.Id
    private val movieTitle = dummyMovie.title

    private val showId = dummyShows.Id
    private val showTitle = dummyShows.title


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Entity>

    @Mock
    private lateinit var showObserver: Observer<Entity>

    @Before
    fun setUpMovie(){
        movieDetailVewModel = DetailViewModel(repository)
        movieDetailVewModel.setSelectedCourse(movieId,movieTitle)
    }

    @Test
    fun getMovies() {
        val movie = MutableLiveData<Entity>()
        movie.value = dummyMovie

        `when`(repository.getDetail(movieId,movieTitle)).thenReturn(movie)
        val dataEntity = movieDetailVewModel.getData().value
        verify(repository).getDetail(movieId,movieTitle)

        assertNotNull(dataEntity)
        assertEquals(dummyMovie.Id,dataEntity?.Id)
        assertEquals(dummyMovie.title,dataEntity?.title)
        assertEquals(dummyMovie.description,dataEntity?.description)

        movieDetailVewModel.dataRepository.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Before
    fun setUpShow(){
        showDetailViewlModel = DetailViewModel(repository)
        showDetailViewlModel.setSelectedCourse(showId,showTitle)
    }

    @Test
    fun getShows() {
        val show = MutableLiveData<Entity>()
        show.value = dummyShows

        `when`(repository.getDetail(showId,showTitle)).thenReturn(show)

        val dataEntity = showDetailViewlModel.getData().value
        verify(repository).getDetail(showId,showTitle)
        assertNotNull(dataEntity)
        assertEquals(dummyShows.Id,dataEntity?.Id)
        assertEquals(dummyShows.title,dataEntity?.title)
        assertEquals(dummyShows.description,dataEntity?.description)

        showDetailViewlModel.dataRepository.observeForever(showObserver)
        verify(showObserver).onChanged(dummyShows)
    }
}