package mzx.imdbproject.service

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import mzx.imdbproject.data.api.FavoritesApi
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.model.DatesData
import mzx.imdbproject.data.model.FavoriteData
import mzx.imdbproject.data.model.MovieCollectionData
import mzx.imdbproject.data.room.model.FavoriteRoom
import mzx.imdbproject.domain.entity.*
import mzx.imdbproject.domain.service.MoviesService
import mzx.imdbproject.domain.usecase.SaveFavoriteMoviesUseCase
import javax.inject.Inject


class MoviesServiceImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val favoritesApi: FavoritesApi
) : MoviesService {

    private val moviesZip =
        BiFunction<MovieCollectionData, List<FavoriteData>, MovieCollectionEntity> { movieCollectionData, favoriteDataList ->
            movieCollectionData.toEntity(favoriteDataList)
        }

    private val moviesFavoriteZip =
        Function3<Unit, MovieCollectionData, List<FavoriteData>, MovieCollectionEntity> { _, movieCollectionData, favoriteDataList ->
            movieCollectionData.toEntity(favoriteDataList)
        }

    override fun saveFavoriteMovie(params: SaveFavoriteMoviesUseCase.FavoriteInfo?): Observable<MovieCollectionEntity> =
        params?.let {

            Observable.zip(
//                Observable.just<Unit>(favoritesApi.saveFavorite(FavoriteRoom(it.id))),
                Observable.fromCallable<Unit> { favoritesApi.saveFavorite(FavoriteRoom(params.id), params.selection) },
            moviesApi.getLatestMovies(),
                favoritesApi.getFavorites(),
                moviesFavoriteZip
            )
        } ?: throw IllegalStateException()


    override fun getLastMovies(): Observable<MovieCollectionEntity> =
        Observable.zip(moviesApi.getLatestMovies(), favoritesApi.getFavorites(), moviesZip)

    override fun dispose() {
    }
}

private fun MovieCollectionData.toEntity(favoriteDataList: List<FavoriteData>): MovieCollectionEntity =
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

                    Math.random() * 100 > 70
                )
            }, totalPages, totalResults
        )
