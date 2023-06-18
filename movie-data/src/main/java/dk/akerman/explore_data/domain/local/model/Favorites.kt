package dk.akerman.explore_data.domain.local.model

data class Favorites(
    var favorites: List<Movie>,
)
data class Movie(
    val id: Int,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String?,
    val adult: Boolean,
    val backdropPath: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)