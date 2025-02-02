package mzx.imdbproject.ui.adapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mzx.imdbproject.R
import mzx.imdbproject.databinding.MoviePagerItemBinding
import mzx.imdbproject.ui.data.MovieUi
import mzx.imdbproject.ui.data.MoviesGroup

class MoviesPagerAdapter(private val listener: MoviesPagerAdapterListener) :
    ListAdapter<MoviesGroup, MoviesPagerAdapter.MoviesPagerViewHolder>(MoviesPagerDiffItem()),
    MovieAdapter.MovieAdapterListener {

    interface MoviesPagerAdapterListener {
        fun onFavoriteClicked(movieUi: MovieUi)
        fun onMovieClicked(movieUi: MovieUi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesPagerViewHolder =
        MoviesPagerViewHolder(
            MoviePagerItemBinding.inflate(
                parent.context.inflater,
                parent,
                false
            )
        ).apply {

            binder.moviesPagerAdapter = MovieAdapter(this@MoviesPagerAdapter)
            binder.movieItem.apply {
                adapter = binder.moviesPagerAdapter
                layoutManager = GridLayoutManager(
                    parent.context, parent.context.resources.getInteger(
                        R.integer.movies_columns
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: MoviesPagerViewHolder, position: Int) {
        holder.binder.moviesPagerAdapter?.submitList(getItem(position).movieUis)
    }

    override fun onBindViewHolder(
        holder: MoviesPagerViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.binder.moviesPagerAdapter?.submitList(getItem(position).movieUis)
        }
    }

    class MoviesPagerViewHolder(val binder: MoviePagerItemBinding) :
        RecyclerView.ViewHolder(binder.root)

    class MoviesPagerDiffItem : DiffUtil.ItemCallback<MoviesGroup>() {
        companion object {
            const val ITEM_UPDATED = "ITEM_UPDATED"

        }

        override fun areItemsTheSame(oldItem: MoviesGroup, newItem: MoviesGroup): Boolean =
            oldItem.groupName == newItem.groupName

        override fun areContentsTheSame(oldItem: MoviesGroup, newItem: MoviesGroup): Boolean =
            oldItem == newItem

        override fun getChangePayload(oldItem: MoviesGroup, newItem: MoviesGroup): Any? =
            if (oldItem != newItem) {
                Bundle().apply {
                    putBoolean(ITEM_UPDATED, true)
                }
            } else {
                null
            }
    }

    override fun onFavoriteClicked(movieUi: MovieUi) {
        listener.onFavoriteClicked(movieUi)
    }

    override fun onMovieClicked(movieUi: MovieUi) {
        listener.onMovieClicked(movieUi)
    }
}