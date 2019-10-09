package mzx.imdbproject.ui.adapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mzx.imdbproject.databinding.MovieItemBinding
import mzx.imdbproject.ui.data.MovieUi

class MovieAdapter(private val listener: MovieAdapterListener) :
    ListAdapter<MovieUi, MovieViewHolder>(MovieUiDiffItem()) {

    interface MovieAdapterListener {
        fun onFavoriteClicked(movieUi: MovieUi)
        fun onMovieClicked(movieUi: MovieUi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(MovieItemBinding.inflate(parent.context.inflater, parent, false)).apply {
            binding.listener = listener
        }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movieUi = getItem(position)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.binding.favorite.isChecked = getItem(position).isFavorite
        }
    }
}

class MovieViewHolder(val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root)

class MovieUiDiffItem : DiffUtil.ItemCallback<MovieUi>() {
    companion object {
        const val FAVORITE = "favorite"
    }

    override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: MovieUi, newItem: MovieUi): Any? = Bundle().apply {
        if (oldItem.isFavorite != newItem.isFavorite) {
            putBoolean(FAVORITE, newItem.isFavorite)
        }
    }
}
