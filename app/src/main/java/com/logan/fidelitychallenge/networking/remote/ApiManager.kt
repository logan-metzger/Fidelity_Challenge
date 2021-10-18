package com.logan.fidelitychallenge.networking.remote

import com.logan.fidelitychallenge.networking.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class ApiManager {
    private val service: ApiService
    private val retrofit = RetrofitInstance.providesRetrofitService()

    init {
        service = retrofit.create(ApiService::class.java)
    }

    suspend fun getAnime(animeTitle: String) = service.getAnime(animeTitle)

    interface ApiService {
        @GET("/v3/search/anime")
        suspend fun getAnime(
            @Query("q") animeTitle: String
        ): Response<ApiResponse>
    }
}