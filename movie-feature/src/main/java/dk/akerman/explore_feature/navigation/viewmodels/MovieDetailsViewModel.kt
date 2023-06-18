package dk.akerman.explore_feature.navigation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.akerman.explore_data.domain.Movie
import dk.akerman.explore_data.domain.local.DeleteFavoriteUseCase
import dk.akerman.explore_data.domain.local.IsFavoriteUseCase
import dk.akerman.explore_data.domain.local.SetFavoriteUseCase
import dk.akerman.explore_data.domain.remote.GetMovieUseCase
import dk.akerman.explore_feature.navigation.navigation.MovieDetailArgs
import dk.akerman.explore_feature.navigation.MovieDetailUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovie: GetMovieUseCase,
    private val setFavorites: SetFavoriteUseCase,
    private val removeFavorites: DeleteFavoriteUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase
) : ViewModel() {

    private val episodeDetailArgs = MovieDetailArgs(savedStateHandle)

    var uiState by mutableStateOf(MovieDetailUiState())
        private set

    init {
        fetchEpisode()
    }

    private fun fetchEpisode() {
        viewModelScope.launch {
            val episodeId = episodeDetailArgs.MovieId
            val data = getMovie(episodeId).getOrDefault(Movie())
            uiState = uiState.copy(data = data)
        }
    }

    fun favoriteClicked(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        val isFavorite = isFavoriteUseCase(movie.id.toString())
        if(isFavorite) {
            try {
                removeFavorites(movie.id.toString())
            } catch (e: Exception) {
                Timber.d("Hey $e")
            }
        } else {
            try {
                setFavorites(movie)
            } catch (e: Exception) {
                Timber.d("Hey $e")
            }
        }
    }
}
