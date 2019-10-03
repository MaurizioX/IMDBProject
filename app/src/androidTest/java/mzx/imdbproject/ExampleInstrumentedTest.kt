package mzx.imdbproject

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import mzx.imdbproject.data.json.api.MockJsonMoviesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val response = MockJsonMoviesApi(appContext).getLatestMovies().blockingFirst()
        response.dates
        assertEquals("mzx.imdbproject", appContext.packageName)
    }
}
