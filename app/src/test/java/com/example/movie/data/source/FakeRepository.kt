package com.example.movie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.remote.ApiResponse
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.data.source.remote.response.MovieResponse
import com.example.movie.data.source.remote.response.ShowResponse
import com.example.movie.utils.AppExecutors
import com.example.movie.vo.Resource

class FakeRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : DataSource {


    override fun getAllMovies(): LiveData<Resource<PagedList<Entity>>> {
       return object : NetworkBoundResource<PagedList<Entity>,List<MovieResponse>>(appExecutors){
           override fun loadFromDB(): LiveData<PagedList<Entity>> {
               val config = PagedList.Config.Builder()
                   .setEnablePlaceholders(false)
                   .setInitialLoadSizeHint(4)
                   .setPageSize(4)
                   .build()
               return LivePagedListBuilder(localDataSource.getAllMovies(),config).build()
           }

           override fun shouldFetch(data: PagedList<Entity>?): Boolean =
               data == null || data.isEmpty()

           override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
               remoteDataSource.getAllMovies()

           override fun saveCallResult(movieResponses: List<MovieResponse>) {
               val movieList = ArrayList<Entity>()
               for (response in movieResponses){
                   val movie = Entity(
                       response.Id,
                       response.title,
                       response.description,
                       response.duration,
                       response.imagePath,
                       response.backdropPath
                   )
                   movieList.add(movie)
               }
               localDataSource.insertData(movieList)
           }
       }.asLiveData()
    }

    override fun getAllShow(): LiveData<Resource<PagedList<Entity>>>{
       return object : NetworkBoundResource<PagedList<Entity>,List<ShowResponse>>(appExecutors){
           override fun loadFromDB(): LiveData<PagedList<Entity>> {
               val config = PagedList.Config.Builder()
                   .setEnablePlaceholders(false)
                   .setInitialLoadSizeHint(4)
                   .setPageSize(4)
                   .build()
               return LivePagedListBuilder(localDataSource.getAllShows(),config).build()
           }

           override fun shouldFetch(data: PagedList<Entity>?): Boolean =
               data == null || data.isEmpty()

           override fun createCall(): LiveData<ApiResponse<List<ShowResponse>>> =
               remoteDataSource.getAllShow()

           override fun saveCallResult(showResponses: List<ShowResponse>) {
               val showList = ArrayList<Entity>()
               for (response in showResponses){
                   val show = Entity(
                       response.Id,
                       response.title,
                       response.description,
                       response.duration,
                       response.imagePath,
                       response.backdropPath
                   )
                   showList.add(show)
               }
               localDataSource.insertData(showList)
           }
       }.asLiveData()
    }

    override fun getDetail(id: String, title: String): LiveData<Entity> =
        localDataSource.getDetails(id, title)

    override fun setDataLiked(data: Entity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setLikedData(data,state) }

    override fun getMovieLiked(): LiveData<PagedList<Entity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getLikedMovies(),config).build()
    }

    override fun getShowLiked(): LiveData<PagedList<Entity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getLikedShows(),config).build()
    }
}