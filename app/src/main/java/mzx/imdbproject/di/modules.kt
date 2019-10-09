package mzx.imdbproject.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mzx.imdbproject.IMDBApp
import mzx.imdbproject.activity.MainActivity
import mzx.imdbproject.data.api.FavoritesApi
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.json.api.MoviesApiImpl
import mzx.imdbproject.data.room.FavoriteDao
import mzx.imdbproject.data.room.MoviesDatabase
import mzx.imdbproject.data.room.api.FavoritesApiImpl
import mzx.imdbproject.domain.executor.PostExecutionThread
import mzx.imdbproject.domain.executor.ThreadExecutor
import mzx.imdbproject.domain.service.MoviesService
import mzx.imdbproject.service.MoviesServiceImpl
import mzx.imdbproject.ui.movie.MovieFragment
import mzx.imdbproject.ui.movie.MovieViewModel
import mzx.imdbproject.utils.JobExecutor
import mzx.imdbproject.utils.UIThread
import mzx.imdbproject.utils.ViewModelFactory
import mzx.imdbproject.utils.ViewModelKey
import javax.inject.Singleton

@Module
abstract class AndroidInjectBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [MainActivityModule::class]
    )
    abstract fun bindMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): MovieFragment
}


@Module
class MainActivityModule {
//    @Provides
//    fun getDependent() = Dependent()
}

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun postListViewModel(viewModel: MovieViewModel): ViewModel

    //Add more ViewModels here
}

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindJobExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    @Singleton
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    abstract fun bindMoviesServiceImpl(moviesServiceImpl: MoviesServiceImpl): MoviesService
}

@Module
abstract class NetworkApi {
    @Binds
    @Singleton
    abstract fun bindMovieApi(moviesApiImpl: MoviesApiImpl): MoviesApi
}

@Module
abstract class CommonModule {
    @Binds
    @Singleton
    abstract fun bindContext(app: IMDBApp): Context
}

@Module
abstract class DbModule {

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun providesDB(context: Context): MoviesDatabase = Room.databaseBuilder(
            context.applicationContext,
            MoviesDatabase::class.java,
            "moviesDB"
        ).build()


        @Provides
        @Singleton
        @JvmStatic
        fun provides(moviesDatabase: MoviesDatabase): FavoriteDao = moviesDatabase.favoriteDao()
    }

    @Binds
    abstract fun bindsFavoritesApi(favoritesApi: FavoritesApiImpl): FavoritesApi

}