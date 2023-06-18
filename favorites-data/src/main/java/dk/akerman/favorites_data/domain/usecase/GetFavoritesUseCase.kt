package dk.akerman.favorites_data.domain.usecase

import dk.akerman.favorites_data.domain.model.Favorites
import dk.akerman.favorites_data.domain.model.Movie
import dk.akerman.favorites_data.domain.repository.FavoritesRepository
import kotlinx.coroutines.CoroutineDispatcher
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