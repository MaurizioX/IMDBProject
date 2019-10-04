package mzx.imdbproject.domain.entity

data class MovieCollectionEntityImpl(
    override val dates: DatesEntity,
    override val page: Int,
    override val results: List<MovieEntity>,
    override val totalPages: Int,
    override val totalResults: Int
) : MovieCollectionEntity

data class DatesEntityImpl(override val maximum: String, override val minimum: String) : DatesEntity

data class MovieEntityImpl(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
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
) : MovieEntity