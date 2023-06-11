import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.akerman.explore_data.usecases.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovies: GetMoviesUseCase
) : ViewModel() {

    val moviesFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        getMovies()
    }.flow.cachedIn(viewModelScope)
}