package com.example.codeschoolandroidlessons.guardian.data.api

import com.example.codeschoolandroidlessons.guardian.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: NewsApi? by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}