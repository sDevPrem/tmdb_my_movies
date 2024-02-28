package com.example.mymovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mymovies.data.datasource.MovieDataSource
import com.example.mymovies.data.repository.paging.TopRatedMoviePagingSource
import com.example.mymovies.domain.model.MovieMeta
import com.example.mymovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource
) : MovieRepository {

    override fun getTopRatedMoviesPagingSource(): Flow<PagingData<MovieMeta>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { TopRatedMoviePagingSource(movieDataSource) }
        ).flow
    }
}