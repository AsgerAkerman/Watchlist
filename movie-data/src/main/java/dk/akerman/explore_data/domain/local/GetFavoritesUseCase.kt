package dk.akerman.explore_data.domain.local

import dk.akerman.explore_data.domain.Movie
import dk.akerman.explore_data.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(): Flow<List<Movie>> = withContext(Dispatchers.IO) {
        movieRepository.getFavorites()
    }
}