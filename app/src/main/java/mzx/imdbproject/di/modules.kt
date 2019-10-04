package mzx.imdbproject.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mzx.imdbproject.IMDBApp
import mzx.imdbproject.activity.MainActivity
import mzx.imdbproject.data.api.MoviesApi
import mzx.imdbproject.data.json.api.MoviesApiImpl
import mzx.imdbproject.domain.executor.PostExecutionThread
import mzx.imdbproject.domain.executor.ThreadExecutor
import mzx.imdbproject.domain.service.MoviesService
import mzx.imdbproject.service.MoviesServiceImpl
import mzx.imdbproject.ui.home.HomeFragment
import mzx.imdbproject.ui.home.HomeViewModel
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
    abstract fun bindHomeFragment(): HomeFragment
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
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun postListViewModel(viewModel: HomeViewModel): ViewModel

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