package com.example.guardian.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guardian.news.data.ContentNewsDto
import com.example.guardian.news.data.ResultDto
import com.example.guardian.news.data.ShowFieldsEnum
import com.example.guardian.news.repository.NewsRepository

open class BaseNewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _resultsLiveData: MutableLiveData<List<ResultDto>> = MutableLiveData()
    val resultsLiveData: LiveData<List<ResultDto>>
        get() = _resultsLiveData

    fun getContentNews(pageNumber: Int = 20, showFieldsEnum: ShowFieldsEnum = ShowFieldsEnum.THUMBNAIL) {
        repository.getContentNews(pageNumber, showFieldsEnum, object : NewsResultCallback<ContentNewsDto?> {
            override fun onSuccess(data: ContentNewsDto?) {
                _resultsLiveData.value = data?.response?.results
            }
        })
    }
}
