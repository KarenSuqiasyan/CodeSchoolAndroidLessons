package com.example.codeschoolandroidlessons.guardianv2.di

import com.example.guardian.news.BaseNewsViewModel
import com.example.guardian.news.Constants.BASE_URL
import com.example.guardian.news.network.NewsApi
import com.example.guardian.news.repository.NewsRepository
import com.example.guardian.news.repository.NewsRepositoryImpl
import com.example.utils.createWebService
import org.koin.dsl.module

fun mainModule() = module {

    single { createWebService<NewsApi>(BASE_URL) }

    single<NewsRepository> { NewsRepositoryImpl(get()) }

    single { BaseNewsViewModel(get()) }

}



