package com.cshomework.codeschoolandroidlessons.guardianv2.ui

import androidx.fragment.app.Fragment
import com.common.guardian.favorite.BaseFavoriteViewModel
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.activity.NewsActivity

val Fragment.newsActivity: NewsActivity?
    get() = activity as? NewsActivity

val Fragment.favoritesViewModel: BaseFavoriteViewModel?
    get() = newsActivity?.favoriteViewModel
