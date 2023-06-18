package dk.akerman.explore_data.domain

import dk.akerman.explore_data.data.remote.MoviePagingSource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getFavorites(): Flow<List<Movie>>
    fun getMovies(): MoviePagingSource

    suspend fun setFavorite(movie: Movie)
    suspend fun removeFavorite(id: String)
    suspend fun getMovie(movieId: String): Result<Movie>
}