package com.lordmegamax.omdbandroidclient.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "Response")
    val response: String,
    @Json(name = "Search")
    val search: List<Search>,
    @Json(name = "totalResults")
    val totalResults: String
)