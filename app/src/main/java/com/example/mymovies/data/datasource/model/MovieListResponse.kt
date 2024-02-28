package com.example.mymovies.data.datasource.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("results")
    val movieList: List<MovieMeta>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
)