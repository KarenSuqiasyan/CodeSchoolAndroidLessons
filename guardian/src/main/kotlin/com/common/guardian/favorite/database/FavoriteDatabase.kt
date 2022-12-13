package com.common.guardian.favorite.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.common.guardian.favorite.database.dao.FavoriteNewsDao
import com.common.guardian.favorite.database.data.FavoriteNewsEntity

@Database(entities = [FavoriteNewsEntity::class], version = 2, exportSchema = true)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteNewsDao(): FavoriteNewsDao
}
