package dk.akerman.explore_data.domain.remote

data class Movies(
    var page: Int,
    var totalResults: Int,
    var totalPages: Int,
    var results: List<Movie>
)

data class Movie(
    var popularity: Double = 0.0,
    var voteCount: Int = 0,
    var video: Boolean = false,
    var posterPath: String? = "",
    var id: Int = 0,
    var originalLanguage: String = "",
    var title: String = "",
    var voteAverage: Double = 0.0,
    var overview: String = "",
    var releaseDate: String = ""
)
