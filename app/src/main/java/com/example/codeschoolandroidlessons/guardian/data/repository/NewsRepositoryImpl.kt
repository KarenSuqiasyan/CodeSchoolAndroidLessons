package com.example.codeschoolandroidlessons.guardian.data.repository

import com.example.codeschoolandroidlessons.guardian.data.api.RetrofitInstance
import com.example.codeschoolandroidlessons.guardian.data.model.ContentNews
import retrofit2.Call

class NewsRepositoryImpl : NewsRepository {

    override fun getContentNews(pageNumber: Int) =
        RetrofitInstance.api?.getContent(pageNumber, "thumbnail")
}