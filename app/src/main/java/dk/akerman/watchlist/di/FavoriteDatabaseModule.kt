package dk.akerman.watchlist.di

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dk.akerman.favorites_data.data.Converters
import dk.akerman.favorites_data.data.MovieDao
import dk.akerman.favorites_data.data.model.MovieLocal

const val DATABASE_NAME = "favorite-database"

@Database(entities = [MovieLocal::class], version = 1)
@TypeConverters(Converters::class)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
