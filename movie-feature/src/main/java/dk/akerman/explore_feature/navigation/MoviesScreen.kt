package dk.akerman.explore_feature.navigation

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import dk.akerman.explore_data.remote.domain.Movie

const val BASE_URL = "https://image.tmdb.org/t/p/w500/"

@Composable
fun MoviesScreen(
    episodeItems: LazyPagingItems<Movie>,
    onNavigateToMovieDetails: (episodeId: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = episodeItems,
            ) { item ->
                if (item != null) {
                    MovieItem(item = item) {
                        onNavigateToMovieDetails(item.id.toString())
                    }
                } else {
                    // Placeholder
                }
            }
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
            .fillMaxWidth()
            .background(Color.Black), onClick = { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = BASE_URL + item.posterPath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            MovieDescription(
                voteAverage = item.voteAverage.toString(),
                releaseDate = item.releaseDate,
                title = item.title,
                overview = item.overview
            )
        }
    }
}

@Composable
fun MovieDescription(
    voteAverage: String,
    title: String,
    releaseDate: String,
    overview: String,
) {
    Row(Modifier.fillMaxWidth()) {
        Column {
            Row {
                Text(
                    modifier = Modifier.weight(2f),
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = Color.White,
                    text = voteAverage,
                    style = MaterialTheme.typography.labelMedium
                )
                Icon(tint = Color.Yellow, imageVector = Icons.Filled.Star, contentDescription = "")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = releaseDate, modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,
                )
            }
        }
    }
    Text(
        overflow = TextOverflow.Ellipsis,
        text = overview,
        style = MaterialTheme.typography.labelMedium,
        maxLines = 3,
        color = Color.White,
    )
}


@Preview
@Composable
fun CharacterCardPreview() {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500//vZloFAK7NmvMGKE7VkF5UHaz0I.jpg",
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    )
}
