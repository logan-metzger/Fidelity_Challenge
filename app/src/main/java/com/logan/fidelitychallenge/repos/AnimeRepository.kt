package com.logan.fidelitychallenge.repos

import com.logan.fidelitychallenge.networking.models.ApiResponse
import com.logan.fidelitychallenge.networking.remote.ApiManager
import retrofit2.Response

object AnimeRepository {
    suspend fun getAnime(animeTitle:String) : Response<ApiResponse> {
        return ApiManager().getAnime(animeTitle)
    }
}