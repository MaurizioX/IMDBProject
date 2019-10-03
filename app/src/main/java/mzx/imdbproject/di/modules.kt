package mzx.imdbproject.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mzx.imdbproject.activity.MainActivity
import mzx.imdbproject.ui.home.HomeFragment
import mzx.imdbproject.ui.home.HomeViewModel
import mzx.imdbproject.utils.ViewModelFactory
import mzx.imdbproject.utils.ViewModelKey

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