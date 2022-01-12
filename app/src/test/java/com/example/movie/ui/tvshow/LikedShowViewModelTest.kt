package com.example.movie.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.movie.data.source.Repository
import com.example.movie.data.source.local.entity.Entity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LikedShowViewModelTest {

    private lateinit var viewModel: LikedShowViewModel

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
        viewModel = LikedShowViewModel(repository)
    }

    @Test
    fun getLikedShows() {
        val dummyShows = pagedList
        val shows = MutableLiveData<PagedList<Entity>>()
        shows.value = dummyShows

        Mockito.`when`(repository.getShowLiked()).thenReturn(shows)
        val entities = viewModel.getLikedShows().value
        verify(repository).getShowLiked()
        assertNotNull(entities)

        viewModel.getLikedShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}