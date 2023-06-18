package dk.akerman.favorites_data

import dk.akerman.favorites_data.domain.model.Movie

sealed class FavoriteUiState {
    object Loading : FavoriteUiState()
    data class Success(val movies: List<Movie>) : FavoriteUiState()
    object Error : FavoriteUiState()
}
