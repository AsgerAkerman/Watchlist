package dk.akerman.explore_data.domain.remote

import dk.akerman.explore_data.data.remote.MoviePagingSource

interface MovieRepository {
    fun getMovies(): MoviePagingSource
    suspend fun getMovie(movieId: String): Result<Movie>
}
