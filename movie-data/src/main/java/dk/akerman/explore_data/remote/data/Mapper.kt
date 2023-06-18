package dk.akerman.explore_data.remote.data

import dk.akerman.explore_data.remote.data.model.MovieRemote
import dk.akerman.explore_data.remote.data.model.MoviesRemote
import dk.akerman.explore_data.remote.domain.Movie
import dk.akerman.explore_data.remote.domain.Movies

internal fun MoviesRemote.mapToDomain(): Movies {
    return Movies(
        page = page,
        totalResults = totalResults,
        totalPages = totalPages,
        results = results.map { it.mapToDomain() }
    )
}

internal fun MovieRemote.mapToDomain(): Movie {
    return Movie(
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        id = id,
        originalLanguage = originalLanguage,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )
}