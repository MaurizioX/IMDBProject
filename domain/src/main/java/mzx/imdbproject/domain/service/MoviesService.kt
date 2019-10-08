package mzx.imdbproject.domain.service

import io.reactivex.Observable
import mzx.imdbproject.domain.entity.MovieCollectionEntity
import mzx.imdbproject.domain.usecase.SaveFavoriteMoviesUseCase

interface MoviesService {
    fun getLastMovies(): Observable<MovieCollectionEntity>
    fun dispose()
    fun saveFavoriteMovie(params: SaveFavoriteMoviesUseCase.FavoriteInfo?): Observable<MovieCollectionEntity>
}