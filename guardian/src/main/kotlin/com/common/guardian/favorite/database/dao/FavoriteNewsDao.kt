package com.common.guardian.favorite.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.common.guardian.favorite.database.data.FavoriteNewsEntity

@Dao
interface FavoriteNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(entity: FavoriteNewsEntity)

    @Query("SELECT * FROM favorite_news_table")
    fun getAllNews(): LiveData<List<FavoriteNewsEntity>>

    @Delete
    fun deleteNews(favoriteNews: FavoriteNewsEntity)
}