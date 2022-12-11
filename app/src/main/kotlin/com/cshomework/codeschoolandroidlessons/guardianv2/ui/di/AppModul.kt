package com.cshomework.codeschoolandroidlessons.guardianv2.ui.di

import com.common.guardian.favorite.BaseFavoriteViewModel
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.activity.NewsActivity
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.contentnews.ContentNewsFragment
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.contentnews.ContentNewsViewModel
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.details.DetailsFragment
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.details.DetailsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val guardianModule = module {

    scope(named<NewsActivity>()) {
        viewModel { BaseFavoriteViewModel(get()) }
    }

    scope(named<ContentNewsFragment>()) {
        viewModel { ContentNewsViewModel(get()) }
    }
    scope(named<DetailsFragment>()) {
        viewModel { DetailsFragmentViewModel(get()) }
    }
}
