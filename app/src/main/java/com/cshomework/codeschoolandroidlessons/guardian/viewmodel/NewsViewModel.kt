//package com.example.codeschoolandroidlessons.guardian.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.MutableLiveData
//import com.example.codeschoolandroidlessons.guardian.data.model.ContentNews
//import com.example.codeschoolandroidlessons.guardian.data.repository.NewsRepository
//import com.example.codeschoolandroidlessons.guardian.util.Resource
//import com.example.base.BaseViewModel
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class NewsViewModel(app: Application, private val newsRepository: NewsRepository): BaseViewModel(app) {
//
//    val contentNews: MutableLiveData<Resource<ContentNews>> = MutableLiveData()
//    val contentNewsErrorLiveData: MutableLiveData<String> = MutableLiveData()
//    private var contentNewsPage = 30
//    var contentNewsResponse: ContentNews? = null
//
//    private fun handleContentNewsResponse(response: Response<ContentNews>): Resource<ContentNews> {
//        if (response.isSuccessful) {
//            response.body()?.let { resultResponse ->
//                contentNewsPage++
//                if (contentNewsResponse == null) {
//                    contentNewsResponse = resultResponse
//                } else {
//                    val oldResults = contentNewsResponse?.response?.results
//                    val newResults = contentNewsResponse?.response?.results
//                    if (newResults != null) {
//                        oldResults?.addAll(newResults)
//                    }
//                }
//                return Resource.Success(contentNewsResponse ?: resultResponse)
//            }
//        }
//        return Resource.Error(response.message())
//    }
//
//    fun getContentNews() {
//        contentNews.postValue(Resource.Loading())
//        val response = newsRepository.getContentNews(contentNewsPage)
//        response?.enqueue(object : Callback<ContentNews> {
//            override fun onResponse(call: Call<ContentNews>, response: Response<ContentNews>) {
//                contentNews.postValue(handleContentNewsResponse(response))
//            }
//
//            override fun onFailure(call: Call<ContentNews>, t: Throwable) {
//                contentNewsErrorLiveData.postValue(t.message)
//            }
//        })
//    }
//}