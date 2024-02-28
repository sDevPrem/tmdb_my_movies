package com.example.mymovies.ui.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.common.data.Result
import com.example.mymovies.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val movie = repository.getMovieDetail(
        savedStateHandle.get<String>(MOVIE_ID_KEY) ?: ""
    ).stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        Result.Loading
    )

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }
}