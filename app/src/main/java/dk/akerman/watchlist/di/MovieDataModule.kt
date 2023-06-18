package dk.akerman.watchlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.akerman.explore_data.data.remote.MovieRemoteDataSource
import dk.akerman.explore_data.data.remote.MovieService
import dk.akerman.explore_data.data.remote.repository.MovieRepositoryImpl
import dk.akerman.explore_data.domain.remote.MovieRepository
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
        remoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }
}
