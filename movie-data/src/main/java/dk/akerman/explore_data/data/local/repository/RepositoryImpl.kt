package dk.akerman.explore_data.data.local.repository

import dk.akerman.explore_data.data.local.MovieDao
import dk.akerman.explore_data.domain.local.model.Movie
import dk.akerman.explore_data.domain.local.repository.FavoritesRepository
import dk.akerman.explore_data.data.mapToData
import dk.akerman.explore_data.data.mapToDomain
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

