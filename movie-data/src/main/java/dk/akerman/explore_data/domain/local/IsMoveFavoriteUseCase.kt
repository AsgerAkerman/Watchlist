package dk.akerman.explore_data.domain.local

import dk.akerman.explore_data.domain.MovieRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: String): Boolean {
        return movieRepository.isMovieFavorite(movieId)
    }
}