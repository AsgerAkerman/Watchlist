package dk.akerman.watchlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.akerman.explore_data.data.MovieRemoteDataSource
import dk.akerman.explore_data.data.MovieService
import dk.akerman.explore_data.data.repository.MovieRepositoryImpl
import dk.akerman.explore_data.domain.MovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MorevieDataModule{

    @Singleton
    @Provides
    fun ProvidesMovieRemoteDataSource(service: MovieService) = MovieRemoteDataSource(service = service)

    @Singleton
    @Provides
    fun ProvidesMovieRepository(
        remoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }
}
