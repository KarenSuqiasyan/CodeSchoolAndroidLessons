package com.common.guardian.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.common.BaseCommonViewModel
import com.common.guardian.news.data.DetailsContentDto
import com.common.guardian.news.data.ContentNewsDto
import com.common.guardian.news.data.DetailsDto
import com.common.guardian.news.data.NewsResultDto
import com.common.guardian.news.model.ShowFieldsEnum
import com.common.guardian.news.repository.NewsRepository
import com.common.net.ResultCallback

open class BaseNewsViewModel(private val repository: NewsRepository) : BaseCommonViewModel() {

    private val _resultsLiveData: MutableLiveData<List<NewsResultDto?>?> = MutableLiveData()
    val resultsLiveData: LiveData<List<NewsResultDto?>?>
        get() = _resultsLiveData

    private val _detailsLiveData: MutableLiveData<DetailsContentDto?> = MutableLiveData()
    val detailsLiveData: LiveData<DetailsContentDto?>
        get() = _detailsLiveData

    fun getContentNews(
        pageNumber: Int = 20,
        showFieldsEnum: ShowFieldsEnum = ShowFieldsEnum.THUMBNAIL
    ) {
        repository.getContentNews(pageNumber, showFieldsEnum,
            object : ResultCallback<ContentNewsDto?> {
                override fun onSuccess(data: ContentNewsDto?) {
                    _resultsLiveData.value = data?.response?.results
                }
            })
    }

    fun getDetails(
        newsId: String
    ) {
        repository.getDetails(newsId, listOf(ShowFieldsEnum.BODY.fields,ShowFieldsEnum.HEADLINE.fields,ShowFieldsEnum.THUMBNAIL.fields).joinToString(","),
            object : ResultCallback<DetailsDto?> {
                override fun onSuccess(data: DetailsDto?) {
                    _detailsLiveData.value = data?.response?.content
                }
            })
    }
}
