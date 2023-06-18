package dk.akerman.explore_data.domain.remote

import dk.akerman.explore_data.domain.remote.Movie
import dk.akerman.explore_data.domain.remote.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: String): Result<Movie> = withContext(Dispatchers.IO) {
        movieRepository.getMovie(movieId)
    }
}
