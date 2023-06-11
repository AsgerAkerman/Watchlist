import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import dk.akerman.explore_data.domain.Movie

@Composable
fun MoviesScreen(
    episodeItems: LazyPagingItems<Movie>,
    onNavigateToEpisodeDetail: (episodeId: String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = episodeItems,
            ) { item ->
                if (item != null) {
                    MovieItem(item = item) {
                        //onNavigateToEpisodeDetail(item.id)
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
    Card(modifier = modifier.fillMaxWidth(), onClick = { onClick() }) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            /*EpisodeTexts(
                episode = item.episode,
                name = item.name,
                airDate = item.airDate,
                modifier = Modifier.weight(1f)
            )*/
            Spacer(modifier = Modifier.width(12.dp))
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
        }
    }
}

@Composable
fun EpisodeTexts(
    episode: String,
    name: String,
    airDate: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = episode, style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = airDate, style = MaterialTheme.typography.labelSmall)
    }
}