package mzx.imdbproject.data.json.model

import com.fasterxml.jackson.annotation.JsonProperty
import mzx.imdbproject.data.model.Dates
import mzx.imdbproject.data.model.Movie
import mzx.imdbproject.data.model.MovieCollection

data class MovieCollectionJson(
    override val dates: DatesJson,
    override val page: Int,
    override val results: List<MovieJson>,
    @JsonProperty("total_pages")
    override val totalPages: Int,
    @JsonProperty("total_results")
    override val totalResults: Int
) : MovieCollection

data class DatesJson(
    override val maximum: String,
    override val minimum: String
) : Dates

data class MovieJson(
    override val adult: Boolean,
    @JsonProperty("backdrop_path")
    override val backdropPath: String,
    @JsonProperty("genre_ids")
    override val genreIds: List<Int>,
    override val id: Int,
    @JsonProperty("original_language")
    override val originalLanguage: String,
    @JsonProperty("original_title")
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    @JsonProperty("poster_path")
    override val posterPath: String,
    @JsonProperty("release_date")
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    @JsonProperty("vote_average")
    override val voteAverage: Double,
    @JsonProperty("vote_count")
    override val voteCount: Int
) : Movie