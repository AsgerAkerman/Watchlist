package dk.akerman.explore_data.remote.domain

import dk.akerman.explore_data.remote.data.MoviePagingSource
import dk.akerman.explore_data.remote.data.model.MovieRemote
import retrofit2.Response

interface MovieRepository {
    fun getMovies(): MoviePagingSource
    suspend fun getMovie(movieId: String): Result<Movie>
}
