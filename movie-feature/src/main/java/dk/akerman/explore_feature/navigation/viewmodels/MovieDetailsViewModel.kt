package dk.akerman.explore_feature.navigation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.akerman.explore_data.domain.Movie
import dk.akerman.explore_data.usecases.GetMovieUseCase
import dk.akerman.explore_feature.navigation.MovieDetailArgs
import dk.akerman.explore_feature.navigation.MovieDetailUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovie: GetMovieUseCase
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
}