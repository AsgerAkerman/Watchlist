package dk.akerman.explore_feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import dk.akerman.explore_feature.navigation.viewmodels.MoviesViewModel

internal const val MoviesRoutePattern = "$MovieGraphRoutePattern/list"

fun NavGraphBuilder.moviesScreen(onNavigateToEpisodeDetail: (episodeId: String) -> Unit) {
    composable(MoviesRoutePattern) {
        val viewModel: MoviesViewModel = hiltViewModel()
        val episodeItems = viewModel.moviesFlow.collectAsLazyPagingItems()

        MoviesScreen(
            episodeItems = episodeItems,
            onNavigateToEpisodeDetail = onNavigateToEpisodeDetail
        )
    }
}
