package dk.akerman.watchlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.akerman.explore_data.data.MovieRepositoryImpl
import dk.akerman.explore_data.data.local.MovieDao
import dk.akerman.explore_data.data.remote.MovieRemoteDataSource
import dk.akerman.explore_data.data.remote.MovieService
import dk.akerman.explore_data.domain.MovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule{

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(service: MovieService) = MovieRemoteDataSource(service = service)

    @Singleton
    @Provides
    fun providesMovieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieDao
    ): MovieRepository {
        return MovieRepositoryImpl(localDataSource = localDataSource, remoteDataSource = remoteDataSource)
    }
}
