package com.example.mymovies.domain.repository

import androidx.paging.PagingData
import com.example.mymovies.domain.model.MovieMeta
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getTopRatedMoviesPagingSource(): Flow<PagingData<MovieMeta>>

}