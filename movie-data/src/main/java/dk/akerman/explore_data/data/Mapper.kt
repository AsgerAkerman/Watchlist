package dk.akerman.explore_data.data

import dk.akerman.explore_data.data.local.model.MovieLocal
import dk.akerman.explore_data.domain.Movie

fun MovieLocal.mapToDomain(): Movie {
    return Movie(
        id = id,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        originalLanguage = originalLanguage,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )
}

fun Movie.mapToData(): MovieLocal {
    return MovieLocal(
        id = id,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        originalLanguage = originalLanguage,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )
}

