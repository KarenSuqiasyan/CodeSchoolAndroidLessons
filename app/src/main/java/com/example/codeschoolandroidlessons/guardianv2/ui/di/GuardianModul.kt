package com.example.codeschoolandroidlessons.guardianv2.ui.di

import com.example.codeschoolandroidlessons.guardianv2.ui.contentnews.ContentNewsFragment
import com.example.codeschoolandroidlessons.guardianv2.ui.contentnews.ContentNewsViewModel
import com.example.guardian.news.BaseNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val guardianModule = module {

//    scope(named<NewsActivity>()) {
//        viewModel { BaseNewsViewModel(get()) }
//    }

    scope(named<ContentNewsFragment>()) {
        viewModel { ContentNewsViewModel(get()) }
    }
}
