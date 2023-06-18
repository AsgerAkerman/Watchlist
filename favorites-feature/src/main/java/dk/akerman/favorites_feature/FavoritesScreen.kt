package dk.akerman.favorites_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dk.akerman.explore_data.domain.Movie

const val BASE_URL = "https://image.tmdb.org/t/p/w500/"

@Composable
fun FavoritesScreen(
    favoriteMovies: FavoriteUiState,
    removeFromFavorites: (movieId: String) -> Unit
) {
    when (favoriteMovies) {
        is FavoriteUiState.Loading -> {
            // Show loading UI
        }
        is FavoriteUiState.Success -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(128.dp),
                    contentPadding = PaddingValues(24.dp)
                ) {
                    items(favoriteMovies.movies) { item ->
                        MovieItem(item = item) {
                            removeFromFavorites(item.id.toString())
                        }
                    }
                }
            }
        }
        is FavoriteUiState.Error -> {
            // Show error UI
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(
    item: Movie,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(3/4f)
            .background(Color.Black), onClick = { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
        )
    ) {
        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = BASE_URL + item.posterPath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.weight(2f),
                text = item.title,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .weight(1f),
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                tint = Color.Red
            )
        }
    }
}
