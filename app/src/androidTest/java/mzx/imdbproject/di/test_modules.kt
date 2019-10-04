package mzx.imdbproject.di

import android.content.Context
import dagger.Binds
import dagger.Module
import mzx.imdbproject.IMDBAppTestApp
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.json.api.MockJsonMoviesApi
import javax.inject.Singleton

@Module
abstract class TestNetworkApi {
    @Binds
    @Singleton
    abstract fun bindMovieApi(mockJsonMoviesApi: MockJsonMoviesApi): MoviesApi
}

@Module
abstract class TestModule {
    @Binds
    abstract fun bindContext(app: IMDBAppTestApp): Context
}