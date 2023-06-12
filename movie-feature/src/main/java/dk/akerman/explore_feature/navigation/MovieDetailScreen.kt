package dk.akerman.explore_feature.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
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

@Composable
fun MovieDetailScreen(
    uiState: MovieDetailUiState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = BASE_URL + uiState.data.posterPath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            MovieDetailDescription(
                voteAverage = uiState.data.voteAverage.toString(),
                releaseDate = uiState.data.releaseDate,
                title = uiState.data.title,
                overview = uiState.data.overview
            )
        }
    }
}

@Composable
fun MovieDetailDescription(
    voteAverage: String,
    title: String,
    releaseDate: String,
    overview: String,
) {
    Column(
        Modifier
            .background(Color.DarkGray, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Row(Modifier.fillMaxWidth()) {
            Column {
                Row {
                    Text(
                        modifier = Modifier.weight(2f),
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
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
                        text = voteAverage,
                        style = MaterialTheme.typography.labelMedium, color = Color.White,

                        )
                    Icon(
                        tint = Color.Yellow,
                        imageVector = Icons.Filled.Star,
                        contentDescription = ""
                    )
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
            color = Color.White,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}