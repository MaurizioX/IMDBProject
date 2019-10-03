package mzx.imdbproject

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import mzx.imdbproject.di.DaggerIMDBAppComponent

class IMDBApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerIMDBAppComponent.builder().application(this).build()
}