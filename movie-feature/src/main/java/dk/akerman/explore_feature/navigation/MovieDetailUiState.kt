package dk.akerman.explore_feature.navigation

import dk.akerman.explore_data.remote.domain.Movie

data class MovieDetailUiState(
    val data: Movie = Movie()
)