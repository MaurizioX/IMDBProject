package mzx.imdbproject.service

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import mzx.imdbproject.data.api.FavoritesApi
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.model.DatesData
import mzx.imdbproject.data.model.FavoriteData
import mzx.imdbproject.data.model.MovieCollectionData
import mzx.imdbproject.domain.entity.*
import mzx.imdbproject.domain.service.MoviesService
import javax.inject.Inject


class MoviesServiceImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val favoritesApi: FavoritesApi
) : MoviesService {
    override fun getLastMovies(): Observable<MovieCollectionEntity> =
        Observable.zip(moviesApi.getLatestMovies(), favoritesApi.getFavorites(),
            BiFunction<MovieCollectionData, List<FavoriteData>, MovieCollectionEntity> { movieCollectionData, favoriteDataList ->
                movieCollectionData.toEntity(favoriteDataList)
            })
//        moviesApi.getLatestMovies().map { movieCollectionData: MovieCollectionData -> movieCollectionData.transform }

    override fun dispose() {
    }
}

private fun MovieCollectionData.toEntity(favoriteDataList: List<FavoriteData>): MovieCollectionEntity = MovieCollectionEntityImpl(
    dates?.transform,
    page,
    results.map {
        MovieEntityImpl(
            it.adult,
            it.backdropPath,
//                    it.genreIds
            emptyList(),
            it.id,
            it.originalLanguage,
            it.originalTitle,
            it.overview,
            it.popularity,
            it.posterPath,
            it.releaseDate,
            it.title,
            it.video,
            it.voteAverage,
            it.voteCount,
            favoriteDataList.any { favoriteData -> favoriteData.id == it.id }
        )
    }, totalPages, totalResults
)



private val DatesData.transform: DatesEntity
    get() = DatesEntityImpl(maximum, minimum)
private val MovieCollectionData.transform: MovieCollectionEntity?
    get() =
        MovieCollectionEntityImpl(
            dates?.transform,
            page,
            results.map {
                MovieEntityImpl(
                    it.adult,
                    it.backdropPath,
//                    it.genreIds
                    emptyList(),
                    it.id,
                    it.originalLanguage,
                    it.originalTitle,
                    it.overview,
                    it.popularity,
                    it.posterPath,
                    it.releaseDate,
                    it.title,
                    it.video,
                    it.voteAverage,
                    it.voteCount,

                    Math.random() *100 > 70
                )
            }, totalPages, totalResults
        )
