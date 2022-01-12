package com.example.movie.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var Id : String,
    var title: String,
    var description: String,
    var duration: String,
    var imagePath: String,
    var backdropPath: String
):Parcelable
