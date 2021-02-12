package com.lordmegamax.omdbandroidclient.data

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query


interface OmdbApi {
    @GET("/")
    fun search(@Query("s") title: String): Single<SearchResponse>
}