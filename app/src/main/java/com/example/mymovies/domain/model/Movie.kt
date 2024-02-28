package com.example.mymovies.domain.model

import java.util.Date

data class Movie(
    val id: String,
    val backDropImgUrl: String,
    val posterImgUrl: String,
    val title: String,
    val description: String,
    val rating: Float,
    val releaseDate: Date,
)