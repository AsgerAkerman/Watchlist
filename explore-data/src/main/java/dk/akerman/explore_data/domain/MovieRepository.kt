package dk.akerman.explore_data.domain

import dk.akerman.explore_data.data.MoviePagingSource
import dk.akerman.explore_data.data.model.MovieRemote
import retrofit2.Response

interface MovieRepository {
    fun getMovies(): MoviePagingSource

    suspend fun getMovie(movieId: String): Result<Movie>
}
