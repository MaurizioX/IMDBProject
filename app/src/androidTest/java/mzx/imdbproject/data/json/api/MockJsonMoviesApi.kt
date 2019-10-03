package mzx.imdbproject.data.json.api

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.reactivex.Observable
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.json.model.MovieCollectionJson
import mzx.imdbproject.data.model.MovieCollectionData
import javax.inject.Inject

class MockJsonMoviesApi @Inject constructor(private val context: Context) : MoviesApi {

    companion object{
        const val MOVIE_RESPONSE = "movies_response.json"
    }
    override fun getLatestMovies(): Observable<MovieCollectionData> = Observable.just(readResponse<MovieCollectionJson>(context, MOVIE_RESPONSE))

    private inline fun <reified T> readResponse(context: Context, fileName: String): T =
        with(ObjectMapper().registerKotlinModule()) {
            val inputStream = context.assets.open(fileName)
            readValue(inputStream)
        }
}