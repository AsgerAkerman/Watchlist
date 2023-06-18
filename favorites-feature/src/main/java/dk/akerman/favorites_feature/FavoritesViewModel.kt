package dk.akerman.favorites_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.akerman.explore_data.domain.local.model.Movie
import dk.akerman.explore_data.domain.local.usecase.DeleteFavoriteUseCase
import dk.akerman.explore_data.domain.local.usecase.GetFavoritesUseCase
import dk.akerman.explore_data.domain.local.usecase.SetFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavorites: GetFavoritesUseCase,
    private val setFavorites: SetFavoriteUseCase,
    private val removeFavorites: DeleteFavoriteUseCase
) : ViewModel() {

    private val _favorites = MutableStateFlow<FavoriteUiState>(FavoriteUiState.Loading)
    val favorites: StateFlow<FavoriteUiState> = _favorites

    init {
        loadFavorites()
    }

    private fun loadFavorites() = viewModelScope.launch(Dispatchers.IO) {
        getFavorites.invoke().catch {
            _favorites.emit(FavoriteUiState.Error)
        }.collect { favoritesList ->
            _favorites.emit(FavoriteUiState.Success(favoritesList))
        }
    }

    fun setFavorite(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        setFavorites(movie)
    }

    fun removeFavorite(movieId: String) = viewModelScope.launch(Dispatchers.IO) {
        removeFavorites(movieId)
    }
}


