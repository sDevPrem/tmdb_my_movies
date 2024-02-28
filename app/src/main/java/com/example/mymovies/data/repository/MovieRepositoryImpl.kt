package com.example.mymovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mymovies.common.data.Result
import com.example.mymovies.common.data.asResult
import com.example.mymovies.data.datasource.MovieDataSource
import com.example.mymovies.data.datasource.model.toDomain
import com.example.mymovies.data.repository.paging.MoviesPagingSource
import com.example.mymovies.domain.model.Movie
import com.example.mymovies.domain.model.MovieMeta
import com.example.mymovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override fun getMovieDetail(id: String): Flow<Result<Movie>> = flow {
        emit(movieDataSource.getMovieDetail(id).toDomain())
    }.asResult()
}