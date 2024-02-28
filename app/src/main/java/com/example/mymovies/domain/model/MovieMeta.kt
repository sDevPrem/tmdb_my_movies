package com.example.mymovies.domain.model

import java.util.Date

data class MovieMeta(
    val id: String,
    val title: String,
    val imgUrl: String,
    val releaseDate: Date,
)