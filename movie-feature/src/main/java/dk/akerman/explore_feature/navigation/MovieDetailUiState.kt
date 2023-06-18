package dk.akerman.explore_feature.navigation

import dk.akerman.explore_data.domain.remote.Movie

data class MovieDetailUiState(
    val data: Movie = Movie()
)