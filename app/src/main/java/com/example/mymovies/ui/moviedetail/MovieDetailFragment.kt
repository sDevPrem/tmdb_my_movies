package com.example.mymovies.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mymovies.common.data.Result
import com.example.mymovies.databinding.FragmentMovieDetailBinding
import com.example.mymovies.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel by viewModels<MovieDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMovieDetailBinding.inflate(
            inflater,
            container,
            false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.movie
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest {
                    when (it) {
                        is Result.Error -> {
                            //show error and put retry button
                        }

                        Result.Loading -> {
                            // hide content and show progressbar
                        }

                        is Result.Success -> {
                            bindData(it.data)
                        }
                    }
                }
        }
    }

    private fun bindData(movie: Movie) = with(binding) {
        movieContent.isVisible = true
        movieAdultSign.isVisible = movie.isAdultMovie
        movieStatus.text = movie.status
        movieTitle.text = movie.title
        movieDesc.text = movie.description
        movieRating.text = movie.rating.toString()
        movieReleaseDate.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            .format(movie.releaseDate)
        Glide.with(requireContext())
            .load(movie.backDropImgUrl)
            .into(movieBackdrop)
    }
}