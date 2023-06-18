package dk.akerman.explore_data.data.remote.repository

import dk.akerman.explore_data.data.remote.MoviePagingSource
import dk.akerman.explore_data.data.remote.MovieRemoteDataSource
import dk.akerman.explore_data.data.remote.mapToDomain
import dk.akerman.explore_data.domain.remote.Movie
import dk.akerman.explore_data.domain.remote.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
    ) : MovieRepository {

    override fun getMovies(): MoviePagingSource {
        return MoviePagingSource(movieRemoteDataSource)
    }

    override suspend fun getMovie(movieId: String): Result<Movie> {
        return movieRemoteDataSource.fetchMovie(movieId).map { it.mapToDomain() }
    }
}
