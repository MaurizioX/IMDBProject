package mzx.imdbproject.data.json.api

import io.reactivex.Observable
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.model.MovieCollectionData
import javax.inject.Inject

class MoviesApiImpl @Inject constructor(): MoviesApi {
    override fun getLatestMovies(): Observable<MovieCollectionData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}