package dk.akerman.favorites_feature

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val FavoritesRoutePattern = "favorites"

fun NavGraphBuilder.favoritesScreen() {
    composable(FavoritesRoutePattern) {
        val viewModel: FavoritesViewModel = hiltViewModel()

        val favoritesState by viewModel.favorites.collectAsState()

        FavoritesScreen(
            favoriteMovies = favoritesState,
            onNavigateToMovieDetails = { movieId ->

            }
        )
    }
}
