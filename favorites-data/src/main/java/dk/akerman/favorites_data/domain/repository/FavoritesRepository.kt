package dk.akerman.favorites_data.domain.repository

import dk.akerman.favorites_data.domain.model.Favorites
import dk.akerman.favorites_data.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavorites(): Flow<List<Movie>>
    suspend fun setFavorite(movie: Movie)
    suspend fun removeFavorite(id: String)

}
