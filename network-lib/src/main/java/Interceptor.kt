import okhttp3.Interceptor
import okhttp3.Response


object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request
            .addHeader("accept", "application/json")
        return chain.proceed(request.build())
    }
}

