package dk.akerman.favorites_data

import dk.akerman.favorites_data.data.model.FavoritesLocal
import dk.akerman.favorites_data.data.model.MovieLocal
import dk.akerman.favorites_data.domain.model.Favorites
import dk.akerman.favorites_data.domain.model.Movie

fun MovieLocal.mapToDomain(): Movie {
    return Movie(
        id = id,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        adult = adult,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        genreIds = genreIds,
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
        adult = adult,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        genreIds = genreIds,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )
}

