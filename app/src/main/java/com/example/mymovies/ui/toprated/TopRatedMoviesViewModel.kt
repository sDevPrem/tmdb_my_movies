package com.example.mymovies.ui.toprated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mymovies.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    repository: MovieRepository
) : ViewModel() {

    val topRatedMovies = repository.getTopRatedMovies()
        .cachedIn(viewModelScope)
}