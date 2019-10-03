package mzx.imdbproject.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mzx.imdbproject.IMDBApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, AndroidInjectBuilder::class, ViewModelModule::class
    ]
)
interface IMDBAppComponent : AndroidInjector<IMDBApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: IMDBApp): Builder

        fun build(): IMDBAppComponent
    }
}