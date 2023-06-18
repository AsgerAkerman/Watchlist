package dk.akerman.explore_data.remote.data

import dk.akerman.explore_data.remote.data.model.MovieRemote
import dk.akerman.explore_data.remote.data.model.MoviesRemote

class MovieRemoteDataSource(private val service: MovieService) {
    suspend fun fetchMovies(page: Int): Result<MoviesRemote> {
        val response = service.getMovies(page)
        if (response.isSuccessful) {
            val moviesRemote = response.body()
            if (moviesRemote != null) {
                return Result.success(moviesRemote)
            }
        }
        return Result.failure(Exception("Failed to fetch movies"))
    }

    suspend fun fetchMovie(movieId: String): Result<MovieRemote> {
        val response = service.getMovie(movieId)
        if (response.isSuccessful) {
            val movieRemote = response.body()
            if (movieRemote != null) {
                return Result.success(movieRemote)
            }
        }
        return Result.failure(Exception("Failed to fetch movie"))
    }
}
