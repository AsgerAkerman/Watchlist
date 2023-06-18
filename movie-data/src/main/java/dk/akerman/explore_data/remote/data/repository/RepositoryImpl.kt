package dk.akerman.explore_data.remote.data.repository

import dk.akerman.explore_data.remote.data.MoviePagingSource
import dk.akerman.explore_data.remote.data.MovieRemoteDataSource
import dk.akerman.explore_data.remote.data.mapToDomain
import dk.akerman.explore_data.remote.domain.Movie
import dk.akerman.explore_data.remote.domain.MovieRepository

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
