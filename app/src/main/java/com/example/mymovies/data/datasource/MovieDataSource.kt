package com.example.mymovies.data.datasource

import com.example.mymovies.data.datasource.model.Movie
import com.example.mymovies.data.datasource.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDataSource {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovieList(@Query("page") page: Int): MovieListResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieListResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: String): Movie

}