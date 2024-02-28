package com.example.mymovies.domain.repository

import androidx.paging.PagingData
import com.example.mymovies.domain.model.MovieMeta
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getTopRatedMovies(): Flow<PagingData<MovieMeta>>

    fun getPopularMovies(): Flow<PagingData<MovieMeta>>

}