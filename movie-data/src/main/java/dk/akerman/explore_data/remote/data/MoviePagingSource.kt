package dk.akerman.explore_data.remote.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.akerman.explore_data.remote.domain.Movie
import timber.log.Timber

class MoviePagingSource(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val nextPage = params.key ?: 1
        return movieRemoteDataSource.fetchMovies(nextPage).fold(
            onSuccess = {
                Timber.d("Hey ${it}")
                val nextKey = if (it.page < it.totalPages) it.page + 1 else null

                LoadResult.Page(
                    data = it.mapToDomain().results,
                    prevKey = null,
                    nextKey = nextKey
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        // The refresh key is the key for the first page (page 1) or null if it doesn't exist
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
