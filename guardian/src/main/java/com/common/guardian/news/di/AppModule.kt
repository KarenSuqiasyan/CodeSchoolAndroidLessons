package com.common.guardian.news.di

import com.common.guardian.news.BaseNewsViewModel
import com.common.guardian.news.GuardianConstants
import com.common.guardian.news.api.NewsApi
import com.common.guardian.news.repository.NewsRepository
import com.common.guardian.news.repository.NewsRepositoryImpl
import com.common.net.createWebService
import org.koin.dsl.module

fun newsModule() = module {

    single { createWebService<NewsApi>(GuardianConstants.BASE_URL) }

    single<NewsRepository> { NewsRepositoryImpl(get()) }

    single { BaseNewsViewModel(get()) }
}