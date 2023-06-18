package dk.akerman.watchlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dk.akerman.explore_feature.navigation.navigation.MovieGraphRoutePattern
import dk.akerman.favorites_feature.FavoritesRoutePattern
import dk.akerman.watchlist.ui.theme.WatchlistTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchlistTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = { ShowcaseNavigationBar(navController = navController) }) { innerPadding ->
                    WatchListNavGraph(
                        navHostController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowcaseNavigationBar(
    navController: NavController
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val navigationBarItem = mapOf(
            MovieGraphRoutePattern to Icons.Filled.List,
            FavoritesRoutePattern to Icons.Filled.Favorite,
            )

        navigationBarItem.forEach { (screen, icon) ->
            NavigationBarItem(
                modifier = Modifier.background(Color.DarkGray),
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (currentDestination?.hierarchy?.any { it.route == screen } == true)
                            Color.DarkGray
                        else
                            Color.White
                    )
                },
                label = { Text(text = screen, color = Color.White) },
                selected = currentDestination?.hierarchy?.any { it.route == screen } == true,
                onClick = {
                    navController.navigate(screen) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
