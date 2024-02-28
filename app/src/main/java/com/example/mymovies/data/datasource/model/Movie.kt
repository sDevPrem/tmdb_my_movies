package com.example.mymovies.data.datasource.model

import com.example.mymovies.data.datasource.contants.ApiConfig
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("backdrop_path")
    val backDropPath: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("status")
    val status: String,
)

fun Movie.toDomain() = com.example.mymovies.domain.model.Movie(
    id = id,
    backDropImgUrl = ApiConfig.IMAGE_BASE_URL + backDropPath,
    posterImgUrl = ApiConfig.IMAGE_BASE_URL + posterPath,
    title = title,
    description = overview,
    rating = voteAverage,
    releaseDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        .parse(releaseDate) ?: Date(),
    isAdultMovie = isAdult,
    status = status
)