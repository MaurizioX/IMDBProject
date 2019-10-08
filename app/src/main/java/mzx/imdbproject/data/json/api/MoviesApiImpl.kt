package mzx.imdbproject.data.json.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import io.reactivex.Observable
import mzx.imdbproject.BuildConfig
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.json.model.MovieCollectionJson
import mzx.imdbproject.data.model.MovieCollectionData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import timber.log.Timber
import javax.inject.Inject

class MoviesApiImpl @Inject constructor() : MoviesApi {
    private val client = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        .build()
    private val movieRetrofitApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().apply {
            disable(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
            )
        }))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(MovieRetrofitApi::class.java)


    override fun getLatestMovies(): Observable<MovieCollectionData> = movieRetrofitApi.getMovies(
        BuildConfig.API_KEY,
        "en-US",
        "run",
        "1",
        false
    ).map { it ->
        Timber.d(it.toString())
        it
    }
}

interface MovieRetrofitApi {
    @GET("/3/search/movie")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: String,
        @Query("include_adult") includeAdult: Boolean
    ): Observable<MovieCollectionJson>
}