package com.example.mymovies.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mymovies.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    repository: MovieRepository
) : ViewModel() {

    val popularMovies = repository.getPopularMovies()
        .cachedIn(viewModelScope)
}