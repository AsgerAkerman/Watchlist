package dk.akerman.watchlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dk.akerman.explore_feature.navigation.MovieGraphRoutePattern
import dk.akerman.explore_feature.navigation.movieGraph


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
    }
}