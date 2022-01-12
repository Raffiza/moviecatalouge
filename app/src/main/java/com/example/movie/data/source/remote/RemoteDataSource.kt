package com.example.movie.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.source.remote.response.MovieResponse
import com.example.movie.data.source.remote.response.ShowResponse
import com.example.movie.utils.EspressoIdlingResources
import com.example.movie.utils.JsonHelper


class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS : Long = 2000
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
                            resultMovie.value = ApiResponse.success(jsonHelper.loadAllMovie())
                            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getAllShow() : LiveData<ApiResponse<List<ShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultShow = MutableLiveData<ApiResponse<List<ShowResponse>>>()
        handler.postDelayed({
                            resultShow.value = ApiResponse.success(jsonHelper.loadAllShow())
                            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
        return resultShow
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }
    interface LoadShowsCallback {
        fun onAllShowsReceived(showResponses: List<ShowResponse>)
    }

}
