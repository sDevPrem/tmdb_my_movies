package com.example.mymovies.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mymovies.databinding.RvItemMovieBinding
import com.example.mymovies.domain.model.MovieMeta
import java.text.SimpleDateFormat
import java.util.Locale

class MoviesAdapter : PagingDataAdapter<MovieMeta, MoviesAdapter.MovieItemViewHolder>(
    diffCallback = DIFFER
) {
    class MovieItemViewHolder(
        private val binding: RvItemMovieBinding
    ) : ViewHolder(binding.root) {

        fun bind(movieMeta: MovieMeta) = binding.run {
            movie = movieMeta
            tvMovieYear.text = SimpleDateFormat("yyyy", Locale.getDefault())
                .format(movieMeta.releaseDate)
            Glide.with(imgMovieImg.context)
                .load(movieMeta.imgUrl)
                .into(imgMovieImg)
            return@run
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(
            RvItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movieMeta = getItem(position) ?: return)
    }

    companion object {
        private val DIFFER = object : DiffUtil.ItemCallback<MovieMeta>() {
            override fun areItemsTheSame(oldItem: MovieMeta, newItem: MovieMeta): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieMeta, newItem: MovieMeta): Boolean {
                return oldItem == newItem
            }

        }
    }

}