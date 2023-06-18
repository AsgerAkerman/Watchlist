package dk.akerman.favorites_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.akerman.favorites_data.FavoriteUiState
import dk.akerman.favorites_data.domain.model.Movie
import dk.akerman.favorites_data.domain.usecase.DeleteFavoriteUseCase
import dk.akerman.favorites_data.domain.usecase.GetFavoritesUseCase
import dk.akerman.favorites_data.domain.usecase.SetFavoriteUseCase
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


