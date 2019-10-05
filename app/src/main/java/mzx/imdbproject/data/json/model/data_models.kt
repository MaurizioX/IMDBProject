package mzx.imdbproject.data.json.model

import com.fasterxml.jackson.annotation.JsonProperty
import mzx.imdbproject.data.model.DatesData
import mzx.imdbproject.data.model.MovieData
import mzx.imdbproject.data.model.MovieCollectionData

data class MovieCollectionJson(
    @JsonProperty("dates")
    override val dates: DatesJson?,
    @JsonProperty("page")
    override val page: Int,
    @JsonProperty("results")
    override val results: List<MovieJson>,
    @JsonProperty("total_pages")
    override val totalPages: Int,
    @JsonProperty("total_results")
    override val totalResults: Int
) : MovieCollectionData

data class DatesJson(
    @JsonProperty("maximum")
    override val maximum: String,
    @JsonProperty("minimum")
    override val minimum: String
) : DatesData

data class MovieJson(
    @JsonProperty("adult")
    override val adult: Boolean,
    @JsonProperty("backdrop_path")
    override val backdropPath: String,
    @JsonProperty("genre_ids")
    override val genreIds: List<Int>,
    @JsonProperty("id")
    override val id: Int,
    @JsonProperty("original_language")
    override val originalLanguage: String,
    @JsonProperty("original_title")
    override val originalTitle: String,
    @JsonProperty("overview")
    override val overview: String,
    @JsonProperty("popularity")
    override val popularity: Double,
    @JsonProperty("poster_path")
    override val posterPath: String,
    @JsonProperty("release_date")
    override val releaseDate: String,
    @JsonProperty("title")
    override val title: String,
    @JsonProperty("video")
    override val video: Boolean,
    @JsonProperty("vote_average")
    override val voteAverage: Double,
    @JsonProperty("vote_count")
    override val voteCount: Int
) : MovieData