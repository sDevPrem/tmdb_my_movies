package com.example.mymovies.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mymovies.data.datasource.model.MovieListResponse
import com.example.mymovies.data.datasource.model.toDomain
import com.example.mymovies.domain.model.MovieMeta

class MoviesPagingSource(
    private val dataSource: suspend (page: Int) -> MovieListResponse
) : PagingSource<Int, MovieMeta>() {

    override fun getRefreshKey(state: PagingState<Int, MovieMeta>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieMeta> {
        return try {
            val movies = dataSource.invoke(
                params.key ?: 1
            )

            LoadResult.Page(
                data = movies.movieList.map { it.toDomain() },
                prevKey = if (movies.page == 1) null else movies.page - 1,
                nextKey = if (movies.page == movies.totalPages) null else movies.page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}