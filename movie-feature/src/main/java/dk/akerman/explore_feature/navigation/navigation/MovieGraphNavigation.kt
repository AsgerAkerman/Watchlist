package dk.akerman.explore_feature.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

const val MovieGraphRoutePattern = "Explore movies"

fun NavGraphBuilder.movieGraph(navController: NavController) {
    navigation(
        startDestination = MoviesRoutePattern,
        route = MovieGraphRoutePattern
    ) {
        moviesScreen { movieId -> navController.navigateToEpisodeDetail(movieId) }
        movieDetailScreen()
    }
}
