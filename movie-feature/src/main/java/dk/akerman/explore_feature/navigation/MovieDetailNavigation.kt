package dk.akerman.explore_feature.navigation

import MovieDetailScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val MovieIdArgs = "episodeId"
private const val MovieRoutePattern = "$MovieGraphRoutePattern/detail/"

internal class MovieDetailArgs(val MovieId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(checkNotNull(savedStateHandle[MovieIdArgs]) as String)
}

internal fun NavGraphBuilder.episodeDetailScreen() {
    composable("$MovieRoutePattern{$MovieIdArgs}") {
        val viewModel: MovieDetailsViewModel = hiltViewModel()
        val uiState = viewModel.uiState
        MovieDetailScreen(uiState = uiState)
    }
}

internal fun NavController.navigateToEpisodeDetail(episodeId: String) {
    navigate("$MovieRoutePattern$episodeId")
}