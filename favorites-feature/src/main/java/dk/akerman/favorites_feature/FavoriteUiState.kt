package dk.akerman.favorites_feature

import dk.akerman.explore_data.domain.Movie


sealed class FavoriteUiState {
    object Loading : FavoriteUiState()
    data class Success(val movies: List<Movie>) : FavoriteUiState()
    object Error : FavoriteUiState()
}
