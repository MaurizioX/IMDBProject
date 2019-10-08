package mzx.imdbproject.data.room

import android.content.Context
import androidx.room.*
import io.reactivex.Observable
import mzx.imdbproject.data.room.model.FavoriteRoom
import mzx.imdbproject.data.room.model.MovieRoom

@Database(entities = [MovieRoom::class, FavoriteRoom::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDato(): MoviesDao

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        var INSTANCE: MoviesDatabase? = null

        fun getAppDataBase(context: Context): MoviesDatabase? {
            if (INSTANCE == null) {
                synchronized(MoviesDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDatabase::class.java,
                        "moviesDB"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}


@Dao
interface MoviesDao {

    @Insert
    fun insert(movies: MovieRoom)

    @Query("DELETE FROM movies_table")
    fun deleteAllMovies()

    @Query("SELECT * FROM movies_table ")
    fun getAllMovies(): Observable<List<MovieRoom>>

}

@Dao
interface FavoriteDao {

    @Insert
    fun insert(movies: FavoriteRoom)

    @Delete
    fun delete(movies: FavoriteRoom)

    @Query("DELETE FROM favorite_table")
    fun deleteAllFavorites()

    @Query("SELECT * FROM favorite_table ")
    fun getAllMovies(): Observable<List<FavoriteRoom>>

}
