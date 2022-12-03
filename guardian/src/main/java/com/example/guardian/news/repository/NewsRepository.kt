package com.example.guardian.news.repository

import com.example.guardian.news.NewsResultCallback
import com.example.guardian.news.data.ContentNewsDto
import com.example.guardian.news.data.ShowFieldsEnum
import com.example.guardian.news.network.NewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface NewsRepository {
    fun getContentNews(pageNumber: Int, showFieldsEnum: ShowFieldsEnum, resultCallback: NewsResultCallback<ContentNewsDto?>)
}

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {
    override fun getContentNews(pageNumber: Int, showFieldsEnum: ShowFieldsEnum, resultCallback: NewsResultCallback<ContentNewsDto?>) {
        newsApi
            .getContentNews(pageNumber = pageNumber, showFields = showFieldsEnum.fields)
            .enqueue(object : Callback<ContentNewsDto> {
                override fun onResponse(call: Call<ContentNewsDto>, response: Response<ContentNewsDto>) {
                    if (response.isSuccessful) {
                        resultCallback.onSuccess(response.body())
                    } else {
                        resultCallback.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<ContentNewsDto>, t: Throwable) {
                }

            })
    }
}