package com.example.codeschoolandroidlessons.guardian.data.repository

import com.example.codeschoolandroidlessons.guardian.data.api.RetrofitInstance

class NewsRepository {

    fun getContentNews(pageNumber: Int) =
        RetrofitInstance.api.getContent(pageNumber,"thumbnail")
}