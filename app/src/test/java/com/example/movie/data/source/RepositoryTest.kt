package com.example.movie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.utils.AppExecutors
import com.example.movie.utils.DataDummy
import com.example.movie.utils.LiveDataTestUtil
import com.example.movie.utils.PagedListUtil
import com.example.movie.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = FakeRepository(remote,local,appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].Id
    private val movieTitle = movieResponses[0].title

    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].Id
    private val showTitle = showResponses[0].title


    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,Entity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        repository.getAllMovies()

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(entities.data)
        assertEquals(movieResponses.size.toLong(),entities.data?.size?.toLong())
    }

    @Test
    fun getAllShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,Entity>
        `when`(local.getAllShows()).thenReturn(dataSourceFactory)
        repository.getAllShow()

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getAllShows()
        assertNotNull(entities.data)
        assertEquals(showResponses.size.toLong(),entities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyDetails = MutableLiveData<Entity>()
        dummyDetails.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetails(movieId,movieTitle)).thenReturn(dummyDetails)

        val entities = LiveDataTestUtil.getValue(repository.getDetail(movieId,movieTitle))
        verify(local).getDetails(movieId,movieTitle)

        assertNotNull(entities)
        assertNotNull(entities.title)
        assertEquals(movieResponses[0].title, entities.title)
    }

    @Test
    fun getShowDetail() {
        val dummyDetails = MutableLiveData<Entity>()
        dummyDetails.value = DataDummy.generateDummyShows()[0]
        `when`(local.getDetails(showId,showTitle)).thenReturn(dummyDetails)

        val entities = LiveDataTestUtil.getValue(repository.getDetail(showId,showTitle))
        verify(local).getDetails(showId,showTitle)

        assertNotNull(entities)
        assertNotNull(entities.title)
        assertEquals(showResponses[0].title, entities.title)
    }

    @Test
    fun getLikedMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,Entity>
        `when`(local.getLikedMovies()).thenReturn(dataSourceFactory)
        repository.getMovieLiked()

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getLikedMovies()
        assertNotNull(entities)
        assertEquals(movieResponses.size.toLong(), entities.data?.size?.toLong())
    }

    @Test
    fun getLikedShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,Entity>
        `when`(local.getLikedShows()).thenReturn(dataSourceFactory)
        repository.getShowLiked()

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getLikedShows()
        assertNotNull(entities)
        assertEquals(showResponses.size.toLong(), entities.data?.size?.toLong())
    }

}