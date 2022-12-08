package com.common.guardian.favorite.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.common.guardian.favorite.database.dao.FavoriteNewsDao
import com.common.guardian.favorite.database.data.FavoriteNewsEntity
import com.common.guardian.favorite.database.data.FieldsTypeConverter

@TypeConverters(FieldsTypeConverter::class)
@Database(entities = [FavoriteNewsEntity::class], version = 1, exportSchema = true)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteNewsDao(): FavoriteNewsDao
}
