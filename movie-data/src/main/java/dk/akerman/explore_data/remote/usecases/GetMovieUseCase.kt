package dk.akerman.explore_data.remote.usecases

import dk.akerman.explore_data.remote.domain.Movie
import dk.akerman.explore_data.remote.domain.MovieRepository
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
