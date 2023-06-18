package dk.akerman.explore_data.data

import dk.akerman.explore_data.data.local.MovieDao
import dk.akerman.explore_data.data.remote.MoviePagingSource
import dk.akerman.explore_data.data.remote.MovieRemoteDataSource
import dk.akerman.explore_data.data.remote.mapToDomain
import dk.akerman.explore_data.domain.MovieRepository
import dk.akerman.explore_data.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val localDataSource: MovieDao,
    private val remoteDataSource: MovieRemoteDataSource

    ) : MovieRepository {
    override fun getFavorites(): Flow<List<Movie>> {
        return localDataSource.getFavorites().map { list -> list.map { it.mapToDomain() } }
    }

    override suspend fun setFavorite(movie: Movie) {
        localDataSource.insertMovie(movie = movie.mapToData())
    }

    override suspend fun removeFavorite(id: String) {
        localDataSource.deleteMovie(movieId = id.toInt())
    }

    override suspend fun isMovieFavorite(movieId: String): Boolean {
        return localDataSource.doesMovieExist(movieId = movieId.toInt())
    }

    override fun getMovies(): MoviePagingSource {
        return MoviePagingSource(remoteDataSource)
    }

    override suspend fun getMovie(movieId: String): Result<Movie> {
        return remoteDataSource.fetchMovie(movieId).map { it.mapToDomain() }
    }
}