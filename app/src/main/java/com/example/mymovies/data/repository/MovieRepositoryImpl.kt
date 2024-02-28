package com.example.mymovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mymovies.data.datasource.MovieDataSource
import com.example.mymovies.data.repository.paging.MoviesPagingSource
import com.example.mymovies.domain.model.MovieMeta
import com.example.mymovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource
) : MovieRepository {

    override fun getTopRatedMovies(): Flow<PagingData<MovieMeta>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { MoviesPagingSource(movieDataSource::getTopRatedMovieList) }
        ).flow
    }

    override fun getPopularMovies(): Flow<PagingData<MovieMeta>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { MoviesPagingSource(movieDataSource::getPopularMovies) }
        ).flow
    }
}