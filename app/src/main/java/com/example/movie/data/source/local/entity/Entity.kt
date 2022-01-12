package com.example.movie.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entities")
data class Entity (

        @NonNull
        @ColumnInfo(name = "Id")
        var Id : String,

        @PrimaryKey
        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "duration")
        var duration: String,

        @ColumnInfo(name = "imagePath")
        var imagePath: String,

        @ColumnInfo(name = "backdropPath")
        var backdropPath: String,

        @ColumnInfo(name = "liked")
        var liked: Boolean = false
    )
