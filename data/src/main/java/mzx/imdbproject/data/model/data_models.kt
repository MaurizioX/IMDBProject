package mzx.imdbproject.data.model

interface MovieCollection {
    val dates: Dates
    val page: Int
    val results: List<Movie>
    val totalPages: Int
    val totalResults: Int
}

interface Dates {
    val maximum: String
    val minimum: String
}

interface Movie {
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