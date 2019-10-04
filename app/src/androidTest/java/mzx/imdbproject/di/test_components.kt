package mzx.imdbproject.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mzx.imdbproject.IMDBAppTestApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, AndroidInjectBuilder::class, ViewModelModule::class,
        AppModule::class, TestNetworkApi::class, TestModule::class
    ]
)
interface IMDBTestAppComponent : AndroidInjector<IMDBAppTestApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: IMDBAppTestApp): Builder

        fun build(): IMDBTestAppComponent
    }
}