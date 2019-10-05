package mzx.imdbproject.domain.entity

interface MovieCollectionEntity {
    val dates: DatesEntity?
    val page: Int
    val results: List<MovieEntity>
    val totalPages: Int
    val totalResults: Int
}

interface DatesEntity {
    val maximum: String
    val minimum: String
}

interface MovieEntity {
    val adult: Boolean
    val backdropPath: String
    val genreIds: List<Int>
    val id: Int
    val originalLanguage: String
    val originalTitle: String
    val overview: String
    val popularity: Double
    val posterPath: String
    val releaseDate: String
    val title: String
    val video: Boolean
    val voteAverage: Double
    val voteCount: Int
}
