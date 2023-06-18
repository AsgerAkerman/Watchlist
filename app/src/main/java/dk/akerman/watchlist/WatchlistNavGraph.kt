package dk.akerman.watchlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dk.akerman.explore_feature.navigation.navigation.MovieGraphRoutePattern
import dk.akerman.explore_feature.navigation.navigation.movieGraph
import dk.akerman.favorites_feature.FavoritesScreen
import dk.akerman.favorites_feature.favoritesScreen

@Composable
fun WatchListNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = MovieGraphRoutePattern
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        movieGraph(navHostController)
        favoritesScreen()
    }
}
