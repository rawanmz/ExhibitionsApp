package com.example.exhibitionsapp.data.remote

import com.example.exhibitionsapp.data.model.ExhibitionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ArticApi {
    @GET
    suspend fun getExhibitions(
        @Url url: String = "https://api.artic.edu/api/v1/exhibitions",
        @Query("page") pageNumber: Int = 1,
        @Query("limit") pageLimitSize: Int = 100,
    ): Response<ExhibitionResponse>
}