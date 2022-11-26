package com.example.codeschoolandroidlessons.guardian.data.api

import com.example.codeschoolandroidlessons.guardian.data.model.ContentNews
import com.example.codeschoolandroidlessons.guardian.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers("api-key:${Constants.API_KEY}")
    @GET("search?")
    fun getContent(@Query("page-size") pageNumber: Int, @Query("show-fields") showFields: String): Call<ContentNews>
}