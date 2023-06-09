import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*object RetrofitClient {
    private const val BASE_URL = "http://localhost:8090/v1/"
    fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val apiService: UserApiService = getClient().create(UserApiService::class.java)

}*/

/*
object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Outgoing request to ${request.url}")
        return chain.proceed(request)
    }
}*/
