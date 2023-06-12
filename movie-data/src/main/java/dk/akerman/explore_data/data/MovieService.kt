package dk.akerman.explore_data.data

import dk.akerman.explore_data.BuildConfig
import dk.akerman.explore_data.data.model.MovieRemote
import dk.akerman.explore_data.data.model.MoviesRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<MoviesRemote>

    @GET("movie/{external_id}")
    suspend fun getMovie(
        @Path("external_id") externalId: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<MovieRemote>
}
