package dk.akerman.explore_data.data.repository

import dk.akerman.explore_data.data.MoviePagingSource
import dk.akerman.explore_data.data.MovieRemoteDataSource
import dk.akerman.explore_data.data.mapToDomain
import dk.akerman.explore_data.domain.Movie
import dk.akerman.explore_data.domain.MovieRepository

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
