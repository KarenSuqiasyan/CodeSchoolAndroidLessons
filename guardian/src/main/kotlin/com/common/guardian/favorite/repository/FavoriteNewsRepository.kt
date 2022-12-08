package com.common.guardian.favorite.repository

import androidx.lifecycle.LiveData
import com.common.guardian.favorite.database.dao.FavoriteNewsDao
import com.common.guardian.favorite.database.data.FavoriteNewsEntity

interface FavoriteNewsRepository {
    fun insertNews(entity: FavoriteNewsEntity)

    fun deleteNews(favoriteNews: FavoriteNewsEntity)

    fun getNews(): LiveData<List<FavoriteNewsEntity>>
}

class FavoriteNewsRepositoryImpl(private val dataBase: FavoriteNewsDao) : FavoriteNewsRepository {

    override fun insertNews(entity: FavoriteNewsEntity) = dataBase.insertNews(entity)

    override fun deleteNews(favoriteNews: FavoriteNewsEntity): Unit = dataBase.deleteNews(favoriteNews)

    override fun getNews(): LiveData<List<FavoriteNewsEntity>> = dataBase.getAllNews()
}