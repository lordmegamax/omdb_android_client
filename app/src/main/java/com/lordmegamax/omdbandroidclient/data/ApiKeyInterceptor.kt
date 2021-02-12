package com.lordmegamax.omdbandroidclient.data

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey", apiKey).build()
        return chain.proceed(request.newBuilder().url(url).build())
    }
}