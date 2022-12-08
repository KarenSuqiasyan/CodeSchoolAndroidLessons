package com.common.guardian.favorite

import com.common.BaseCommonViewModel
import com.common.guardian.favorite.database.data.FavoriteNewsEntity
import com.common.guardian.favorite.repository.FavoriteNewsRepository

class BaseFavoriteViewModel(private val repository: FavoriteNewsRepository) : BaseCommonViewModel() {

    fun saveNews(favoriteNews: FavoriteNewsEntity) {
        repository.insertNews(favoriteNews)
    }

    fun getSavedNews() = repository.getNews()

    fun deleteNews(favoriteNews: FavoriteNewsEntity) {
        repository.deleteNews(favoriteNews)
    }
}