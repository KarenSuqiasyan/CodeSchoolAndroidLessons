package com.example.guardian.news.network

import com.example.guardian.news.data.ContentNewsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApi {

    @GET("search?")
    fun getContentNews(
        @Header("api-key") apiKey: String = "test",
        @Query("page-size") pageNumber: Int,
        @Query("show-fields") showFields: String
    ): Call<ContentNewsDto>
}