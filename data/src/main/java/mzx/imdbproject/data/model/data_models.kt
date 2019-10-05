package mzx.imdbproject.data.model

interface MovieCollectionData {
    val dates: DatesData?
    val page: Int
    val results: List<MovieData>
    val totalPages: Int
    val totalResults: Int
}

interface DatesData {
    val maximum: String
    val minimum: String
}

interface MovieData {
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