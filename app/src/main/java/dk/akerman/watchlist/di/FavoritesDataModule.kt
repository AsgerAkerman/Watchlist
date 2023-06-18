package dk.akerman.watchlist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dk.akerman.explore_data.data.local.MovieDao
import dk.akerman.explore_data.data.local.repository.FavoritesRepositoryImpl
import dk.akerman.explore_data.domain.local.repository.FavoritesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoritesDataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FavoriteDatabase {
        return Room.databaseBuilder(
            context,
            FavoriteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideMovieDao(database: FavoriteDatabase): MovieDao {
        return database.movieDao()
    }

    @Provides
    fun provideFavoritesRepository(movieDao: MovieDao): FavoritesRepository {
        return FavoritesRepositoryImpl(movieDao)
    }
}
