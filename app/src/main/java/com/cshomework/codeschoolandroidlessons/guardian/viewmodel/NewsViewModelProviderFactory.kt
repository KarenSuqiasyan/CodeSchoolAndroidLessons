//package com.example.codeschoolandroidlessons.guardian.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.codeschoolandroidlessons.guardian.data.repository.NewsRepository
//
//class NewsViewModelProviderFactory(val app: Application, private val newsRepository: NewsRepository) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return NewsViewModel(app, newsRepository) as T
//    }
//}