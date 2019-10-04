package mzx.imdbproject

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import mzx.imdbproject.di.DaggerIMDBAppComponent
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule


class IMDBApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerIMDBAppComponent.builder().application(this).build()
}



@GlideModule
class IMDBAppGlideModule : AppGlideModule()