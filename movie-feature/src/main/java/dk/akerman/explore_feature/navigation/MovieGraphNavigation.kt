package dk.akerman.explore_feature.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

const val MovieGraphRoutePattern = "movie"

fun NavGraphBuilder.movieGraph(navController: NavController) {
    navigation(
        startDestination = MoviesRoutePattern,
        route = MovieGraphRoutePattern
    ) {
        moviesScreen { movieId -> navController.navigateToEpisodeDetail(movieId) }
        //episodeDetailScreen()
    }
}
