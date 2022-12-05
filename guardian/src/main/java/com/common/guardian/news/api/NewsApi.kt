package com.common.guardian.news.api

import com.common.guardian.news.data.ContentNewsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @Headers("api-key:c4e8c6de-cdfa-42a9-a87d-ef9835041f5a")
    @GET("search?")
    fun getContentNews(
        @Query("page-size") pageNumber: Int,
        @Query("show-fields") showFields: String
    ): Call<ContentNewsDto>
}