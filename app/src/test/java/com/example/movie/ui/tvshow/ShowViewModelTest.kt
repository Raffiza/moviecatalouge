package com.example.movie.ui.tvshow

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
class ShowViewModelTest {

    private lateinit var viewModel: ShowViewModel

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
        viewModel = ShowViewModel(repository)
    }

    @Test
    fun getShow() {
        val dummyShows = Resource.success(pagedList)
        `when`(dummyShows.data?.size).thenReturn(5)
        val shows = MutableLiveData<Resource<PagedList<Entity>>>()
        shows.value = dummyShows

        `when`(repository.getAllShow()).thenReturn(shows)
        val showEntities = viewModel.getShows().value?.data
        verify(repository).getAllShow()
        assertNotNull(showEntities)
        assertEquals(5,showEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}