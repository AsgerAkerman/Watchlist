package dk.akerman.favorites_data.domain.model

import dk.akerman.favorites_data.data.model.MovieLocal

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