package mzx.imdbproject

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class IMDBAppTestRunner: AndroidJUnitRunner() {
    @Throws(IllegalAccessException::class, ClassNotFoundException::class, InstantiationException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, IMDBAppTestApp::class.java.name, context)
    }
}