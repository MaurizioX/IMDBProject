package mzx.imdbproject.ui

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import mzx.imdbproject.GlideApp

@BindingAdapter("app:loadGlide")
fun loadGlide(imageView: AppCompatImageView, url: String) {
    GlideApp.with(imageView.context)
        .load("https://image.tmdb.org/t/p/original$url")
        .into(imageView)
}