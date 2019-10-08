package mzx.imdbproject.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import mzx.imdbproject.data.model.DatesData
import mzx.imdbproject.data.model.FavoriteData
import mzx.imdbproject.data.model.MovieCollectionData
import mzx.imdbproject.data.model.MovieData

data class MovieCollectionRoom(
    override val dates: DatesRoom?,
    override val page: Int,
    override val results: List<MovieRoom>,
    override val totalPages: Int,
    override val totalResults: Int
) : MovieCollectionData

data class DatesRoom(

    override val maximum: String,
    override val minimum: String
) : DatesData

@Entity(tableName = "movies_table")
data class MovieRoom(
    override val adult: Boolean,
    override val backdropPath: String,
//    override val genreIds: List<Int>,
    @PrimaryKey(autoGenerate = false)
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : MovieData

@Entity(tableName = "favorite_table")
data class FavoriteRoom(@PrimaryKey(autoGenerate = false) override val id: Int) : FavoriteData