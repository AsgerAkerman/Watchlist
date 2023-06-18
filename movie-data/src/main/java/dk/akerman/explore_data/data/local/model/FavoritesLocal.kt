package dk.akerman.explore_data.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoritesLocal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorites_id")
    val favoritesId: Int,

    @ColumnInfo(name = "movie_id")
    val movieId: Int
)

@Entity(tableName = "movies")
data class MovieLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
    @ColumnInfo(name = "video")
    val video: Boolean,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String
)
