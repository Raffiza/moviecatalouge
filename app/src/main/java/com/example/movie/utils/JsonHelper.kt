package com.example.movie.utils

import android.content.Context
import com.example.movie.data.source.remote.response.MovieResponse
import com.example.movie.data.source.remote.response.ShowResponse
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context : Context){

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadAllMovie() : List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try{
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = "movie"
                val title = movie.getString("original_title")
                val description = movie.getString("overview")
                val duration = "${movie.getString("runtime")} minutes"
                val imagePath = movie.getString("poster_path")
                val backdropPath = movie.getString("backdrop_path")

                val movieResponse = MovieResponse(id,title, description, duration, imagePath, backdropPath)
                list.add(movieResponse)
            }
        }
        catch (ex : IOException){
            ex.printStackTrace()
        }
        return list
    }

    fun loadAllShow() : List<ShowResponse> {
        val list = ArrayList<ShowResponse>()
        try{
            val responseObject = JSONObject(parsingFileToString("shows.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()){
                val show = listArray.getJSONObject(i)

                val id = "show"
                val title = show.getString("original_name")
                val description = show.getString("overview")
                val durationitem = show.getJSONArray("episode_run_time")
                val duration = "${durationitem.getString(0)} minutes"
                val imagePath = show.getString("poster_path")
                val backdropPath = show.getString("backdrop_path")

                val showResponse = ShowResponse(id,title, description, duration, imagePath, backdropPath)
                list.add(showResponse)
            }
        }
        catch (ex : IOException){
            ex.printStackTrace()
        }
        return list
    }
}