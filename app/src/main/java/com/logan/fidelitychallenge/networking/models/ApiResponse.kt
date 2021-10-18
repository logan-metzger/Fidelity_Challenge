package com.logan.fidelitychallenge.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @field:Json(name = "request_hash")val requestHash: String,
    @field:Json(name = "request_cached")val requestCached: Boolean,
    @field:Json(name = "request_cache_expiry")val requestCacheExpiry: Int,
    @field:Json(name = "results")val results: List<Anime>,
    @field:Json(name = "last_page")val lastPage: Int,
)
