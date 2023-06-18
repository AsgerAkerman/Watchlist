package dk.akerman.favorites_data.data.repository

import dk.akerman.favorites_data.data.MovieDao
import dk.akerman.favorites_data.domain.model.Favorites
import dk.akerman.favorites_data.domain.model.Movie
import dk.akerman.favorites_data.domain.repository.FavoritesRepository
import dk.akerman.favorites_data.mapToData
import dk.akerman.favorites_data.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoritesRepositoryImpl(
    private val localDataSource: MovieDao
) : FavoritesRepository {

    override fun getFavorites(): Flow<List<Movie>> {
        return localDataSource.getFavorites().map { list -> list.map { it.mapToDomain() } }
    }

    override suspend fun setFavorite(movie: Movie) {
        localDataSource.insertMovie(movie = movie.mapToData())
    }

    override suspend fun removeFavorite(id: String) {
        localDataSource.deleteMovie(movieId = id.toInt())
    }
}

