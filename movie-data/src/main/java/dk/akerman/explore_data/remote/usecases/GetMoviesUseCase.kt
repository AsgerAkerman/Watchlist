package dk.akerman.explore_data.remote.usecases

import dk.akerman.explore_data.remote.data.MoviePagingSource
import dk.akerman.explore_data.remote.domain.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): MoviePagingSource {
        return movieRepository.getMovies()
    }
}