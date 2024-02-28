package com.example.mymovies.data.datasource.model

import com.example.mymovies.data.datasource.contants.ApiConfig
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class MovieMeta(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
)

fun MovieMeta.toDomain() = com.example.mymovies.domain.model.MovieMeta(
    id = id.toString(),
    title = title,
    imgUrl = ApiConfig.IMAGE_BASE_URL + posterPath,
    releaseDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        .parse(releaseDate) ?: Date()
)