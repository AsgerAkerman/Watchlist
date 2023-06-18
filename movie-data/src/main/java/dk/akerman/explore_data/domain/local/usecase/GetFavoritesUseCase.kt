package dk.akerman.explore_data.domain.local.usecase

import dk.akerman.explore_data.domain.local.model.Movie
import dk.akerman.explore_data.domain.local.repository.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
) {
    suspend operator fun invoke(): Flow<List<Movie>> = withContext(Dispatchers.IO) {
        favoritesRepository.getFavorites()
    }
}