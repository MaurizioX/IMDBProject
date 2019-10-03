package mzx.imdbproject.data.api

import io.reactivex.Observable
import mzx.imdbproject.data.model.MovieCollectionData

interface MoviesApi {
    fun getLatestMovies(): Observable<MovieCollectionData>
}