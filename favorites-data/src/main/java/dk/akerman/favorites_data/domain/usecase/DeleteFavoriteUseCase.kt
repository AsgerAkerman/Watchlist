package dk.akerman.favorites_data.domain.usecase

import dk.akerman.favorites_data.domain.model.Movie
import dk.akerman.favorites_data.domain.repository.FavoritesRepository
import kotlinx.coroutines.CoroutineDispatcher
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