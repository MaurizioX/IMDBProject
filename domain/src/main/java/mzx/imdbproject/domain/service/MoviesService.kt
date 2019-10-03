package mzx.imdbproject.domain.service

import io.reactivex.Observable
import mzx.imdbproject.domain.entity.MovieCollectionEntity

interface MoviesService {
    fun getLastMovies(): Observable<MovieCollectionEntity>
    fun dispose()
}