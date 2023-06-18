package dk.akerman.explore_data.domain.remote

import dk.akerman.explore_data.data.remote.MoviePagingSource
import dk.akerman.explore_data.domain.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): MoviePagingSource {
        return movieRepository.getMovies()
    }
}