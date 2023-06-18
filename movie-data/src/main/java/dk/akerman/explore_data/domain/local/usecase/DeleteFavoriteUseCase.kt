package dk.akerman.explore_data.domain.local.usecase

import dk.akerman.explore_data.domain.local.repository.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor (
    private val favoritesRepository: FavoritesRepository,
) {
    suspend operator fun invoke(movieId: String) = withContext(Dispatchers.IO) {
        favoritesRepository.removeFavorite(id = movieId)
    }
}