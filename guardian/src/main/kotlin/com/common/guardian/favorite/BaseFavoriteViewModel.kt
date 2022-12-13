package com.common.guardian.favorite

import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.common.BaseCommonViewModel
import com.common.guardian.favorite.database.data.FavoriteNewsEntity
import com.common.guardian.favorite.repository.FavoriteNewsRepository
import com.common.guardian.news.data.DetailsContentDto
import com.common.guardian.news.data.NewsFieldsDto
import com.common.guardian.news.data.NewsResultDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseFavoriteViewModel(private val repository: FavoriteNewsRepository) : BaseCommonViewModel() {

    val favoriteNews = Transformations.map(repository.getNews()) {
        it.map { entity ->
            NewsResultDto(
                id = entity.id,
                webTitle = entity.webTitle,
                sectionName = entity.sectionName,
                fields = NewsFieldsDto(thumbnail = entity.thumbnail)
            )
        }
    }

    fun saveNews(item: DetailsContentDto) = viewModelScope.launch(Dispatchers.IO) { repository.insertNews(item) }

    fun saveNews(item: NewsResultDto) = viewModelScope.launch(Dispatchers.IO) { repository.insertNews(item) }

    fun deleteNews(item: FavoriteNewsEntity) = viewModelScope.launch(Dispatchers.IO) { repository.deleteNews(item) }

    fun deleteNewsById(newsId: String) = viewModelScope.launch(Dispatchers.IO) { repository.deleteNewsById(newsId) }

}