package com.logan.fidelitychallenge.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Anime(
    @field:Json(name = "mal_id")val malId: Int?,
    @field:Json(name = "url")val url: String?,
    @field:Json(name = "image_url")val imageUrl: String,
    @field:Json(name = "title")val title: String,
    @field:Json(name = "airing")val airing: Boolean,
    @field:Json(name = "synopsis")val synopsis: String?,
    @field:Json(name = "type")val type: String?,
    @field:Json(name = "episodes")val episodes: Int?,
    @field:Json(name = "score")val score: Float?,
    @field:Json(name = "start_date")val startDate: String?,
    @field:Json(name = "end_date")val endDate: String?,
    @field:Json(name = "members")val members: Int?,
    @field:Json(name = "rated")val rated: String?,
)
