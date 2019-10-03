package mzx.imdbproject.data.api

import io.reactivex.Observable
import mzx.imdbproject.data.model.MovieCollection

interface MoviesApi {
    fun getLatestMovies(): Observable<MovieCollection>
}