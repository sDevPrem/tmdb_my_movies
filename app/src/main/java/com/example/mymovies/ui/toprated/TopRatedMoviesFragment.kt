package com.example.mymovies.ui.toprated

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mymovies.databinding.FragmentMovieBinding
import com.example.mymovies.ui.common.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val adapter = MoviesAdapter(
        onMovieItemClick = {
            findNavController().navigate(
                TopRatedMoviesFragmentDirections
                    .actionTopRatedMoviesFragmentToMovieDetailFragment(it.id)
            )
        },
        onMovieShareBtnClick = {
            Intent(Intent.ACTION_SEND).apply {
                //send deeplink to open movie detail page
                val movieInfo = "Take a loot at this Movie: ${it.title}"
                putExtra(Intent.EXTRA_TEXT, movieInfo)
                type = "text/plain"
            }.also(::startActivity)
        }
    )
    private val viewModel by viewModels<TopRatedMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMovieBinding.inflate(
            inflater,
            container,
            false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        rvMovies.layoutManager = GridLayoutManager(requireContext(), 2)
        rvMovies.adapter = adapter
        topToolbar.title = "Top Rated Movies"

        lifecycleScope.launch {
            viewModel.topRatedMovies
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest {
                    adapter.submitData(it)
                }
        }
        return@with
    }

}