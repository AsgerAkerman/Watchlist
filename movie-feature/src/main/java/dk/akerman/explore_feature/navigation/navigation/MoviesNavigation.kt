package dk.akerman.explore_feature.navigation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import dk.akerman.explore_feature.navigation.MoviesScreen
import dk.akerman.explore_feature.navigation.viewmodels.MoviesViewModel

internal const val MoviesRoutePattern = "$MovieGraphRoutePattern/list"

fun NavGraphBuilder.moviesScreen(onNavigateToMovieDetails: (episodeId: String) -> Unit) {
    composable(MoviesRoutePattern) {
        val viewModel: MoviesViewModel = hiltViewModel()
        val episodeItems = viewModel.moviesFlow.collectAsLazyPagingItems()

        MoviesScreen(
            episodeItems = episodeItems,
            onNavigateToMovieDetails = onNavigateToMovieDetails
        )
    }
}
