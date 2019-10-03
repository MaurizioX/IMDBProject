package mzx.imdbproject

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import mzx.imdbproject.di.DaggerIMDBTestAppComponent

class IMDBAppTestApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerIMDBTestAppComponent.builder().application(this).build()
}
