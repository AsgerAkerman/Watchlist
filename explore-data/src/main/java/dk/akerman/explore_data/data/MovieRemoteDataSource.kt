package dk.akerman.explore_data.data

import dk.akerman.explore_data.data.model.MovieRemote
import dk.akerman.explore_data.data.model.MoviesRemote
import retrofit2.Response

class MovieRemoteDataSource(
    private val service: MovieService
) {
    suspend fun fetchMovies(page: Int): Result<MoviesRemote> {
        return service.getMovies(page)
    }

    suspend fun fetchMovie(movieId: String): Result<MovieRemote> {
        return service.getMovie(movieId)
    }
}
