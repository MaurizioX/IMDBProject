package mzx.imdbproject.activity


import androidx.test.rule.ActivityTestRule
//import androidx.test.runner.AndroidJUnit4
import androidx.test.runner.AndroidJUnit4
//import androidx.test.ext.junit.runners.AndroidJUnit4


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkActivityDataLoading() {
        Thread.sleep(5000)
    }
}
