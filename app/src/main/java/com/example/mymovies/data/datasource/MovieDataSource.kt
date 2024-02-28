package com.example.mymovies.data.datasource

import com.example.mymovies.data.datasource.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataSource {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovieList(@Query("page") page: Int): MovieListResponse

}