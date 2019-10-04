package mzx.imdbproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mzx.imdbproject.databinding.MovieItemBinding
import mzx.imdbproject.ui.data.MovieUi

private val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)


class MovieAdapter : ListAdapter<MovieUi, MovieViewHolder>(MovieUiDiffItem()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(MovieItemBinding.inflate(parent.context.inflater, parent, false))


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movieUi = getItem(position)
    }
}

class MovieViewHolder(val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}

class MovieUiDiffItem : DiffUtil.ItemCallback<MovieUi>() {
    override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean =
        oldItem == newItem
}
