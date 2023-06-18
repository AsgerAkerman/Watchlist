package dk.akerman.explore_data.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dk.akerman.explore_data.data.local.model.MovieLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getFavorites(): Flow<List<MovieLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieLocal)

    @Query("DELETE FROM movies WHERE id = :movieId")
    suspend fun deleteMovie(movieId: Int)

    @Query("SELECT EXISTS(SELECT * FROM movies WHERE id = :movieId)")
    suspend fun doesMovieExist(movieId: Int): Boolean
}

