package dk.akerman.explore_data.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.akerman.explore_data.data.model.MovieRemote

class MoviePagingSource(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : PagingSource<Int, MovieRemote>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieRemote> {
        val page = params.key ?: 1
        return try {
            val response = movieRemoteDataSource.fetchMovies(page)

            if (response.isSuccessful) {
                val movies = response.body()?.results

                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (page < (response.body()?.totalPages ?: 0)) page + 1 else null

                if (movies != null) {
                    LoadResult.Page(data = movies, prevKey = prevKey, nextKey = nextKey)
                } else {
                    LoadResult.Error(Exception("No movies found"))
                }
            } else {
                LoadResult.Error(Exception("Failed to fetch movies: ${response.code()}"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieRemote>): Int? {
        // The refresh key is the key for the first page (page 1) or null if it doesn't exist
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

