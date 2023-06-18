import androidx.lifecycle.SavedStateHandle
import dk.akerman.explore_data.domain.Movie
import dk.akerman.explore_data.domain.local.DeleteFavoriteUseCase
import dk.akerman.explore_data.domain.local.IsFavoriteUseCase
import dk.akerman.explore_data.domain.local.SetFavoriteUseCase
import dk.akerman.explore_data.domain.remote.GetMovieUseCase
import dk.akerman.explore_feature.navigation.viewmodels.MovieDetailsViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class MovieDetailsViewModelTest {

    // Create mocks for all dependencies
    private val getMovieUseCase: GetMovieUseCase = mockk()
    private val setFavoriteUseCase: SetFavoriteUseCase = mockk()
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase = mockk()
    private val isFavoriteUseCase: IsFavoriteUseCase = mockk()
    private val savedStateHandle: SavedStateHandle = mockk()
    private lateinit var viewModel: MovieDetailsViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        // Mock the get() method for savedStateHandle
        every { savedStateHandle.get<String>("episodeId") } returns "mockedEpisodeId"

        // Initialize the ViewModel before each test
        viewModel = MovieDetailsViewModel(
            savedStateHandle,
            getMovieUseCase,
            setFavoriteUseCase,
            deleteFavoriteUseCase,
            isFavoriteUseCase
        )
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchMovie should set UiState data when getMovieUseCase returns Movie`() = runBlocking {
        // Given a Movie from the GetMovieUseCase
        val movie = Movie()
        coEvery { getMovieUseCase(any()) } returns Result.success(movie)

        // When fetchEpisode is called
        viewModel.fetchEpisode()

        // Then the UiState data should be the movie
        assert(viewModel.uiState.data == movie)
    }

    @Test
    fun `favoriteClicked should remove favorite if movie is favorite`() = runBlocking {
        // Given a Movie
        val movie = Movie()

        // And the IsFavoriteUseCase indicates it is a favorite
        coEvery { isFavoriteUseCase(any()) } returns true

        // When favoriteClicked is called
        viewModel.favoriteClicked(movie)

        // Then the DeleteFavoriteUseCase should be invoked
        coVerify { deleteFavoriteUseCase(movie.id.toString()) }
    }

}
