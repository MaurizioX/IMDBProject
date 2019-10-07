package mzx.imdbproject.data.room

import androidx.room.*
import io.reactivex.Observable
import mzx.imdbproject.data.room.model.MovieRoom

@Database(entities = [MovieRoom::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
}


@Dao
interface NoteDao {

    @Insert
    fun insert(movies: MovieRoom)

    @Query("DELETE FROM movies_table")
    fun deleteAllMovies()

    @Query("SELECT * FROM movies_table ")
    fun getAllMovies(): Observable<List<MovieRoom>>

}
