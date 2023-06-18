package dk.akerman.explore_data.domain.local.repository

import dk.akerman.explore_data.domain.local.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavorites(): Flow<List<Movie>>
    suspend fun setFavorite(movie: Movie)
    suspend fun removeFavorite(id: String)

}
