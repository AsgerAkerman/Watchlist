import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0ODg1MzA5NmFiMGY4MDIzNjA3YmI4NTNkNmFhZDI5MyIsInN1YiI6IjY0Nzg1N2I0OTM4MjhlMDBmOWQ1ZTYwYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gKYrBkHvXE1V-rf0m9S1cRvO2Lpx89lkP-7YP2yK9Iw")
            .addHeader("accept", "application/json")

        return chain.proceed(request.build())
    }
}
