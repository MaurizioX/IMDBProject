package mzx.imdbproject.ui.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieUi(
    val id: Int, val originalTitle: String, val overview: String, val popularity: Double,
    val posterPath: String, val releaseDate: String, val title: String, val video: Boolean,
    val voteAverage: Double, val voteCount: Int, val isFavorite: Boolean = false
) : Parcelable

@Parcelize
data class MoviesGroup(val groupName: String, val movieUis: List<MovieUi>) : Parcelable