package dk.akerman.explore_data.domain

data class Movies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<Movie>
)

data class Movie(
    val popularity: Double = 0.0,
    val voteCount: Int = 0,
    val video: Boolean = false,
    val posterPath: String? = "",
    val id: Int = 0,
    val originalLanguage: String = "",
    val genreIds: List<Int> = emptyList(),
    val title: String = "",
    val voteAverage: Double = 0.0,
    val overview: String = "",
    val releaseDate: String = ""
)
