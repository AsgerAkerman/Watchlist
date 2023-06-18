package dk.akerman.explore_data.domain.local

import dk.akerman.explore_data.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor (
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(movieId: String) = withContext(Dispatchers.IO) {
        movieRepository.removeFavorite(id = movieId)
    }
}