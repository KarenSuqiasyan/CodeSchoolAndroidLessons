package com.common.guardian.favorite.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.common.guardian.news.data.FieldsDto
import com.google.gson.annotations.JsonAdapter

@Entity(tableName = "favorite_news_table")
data class FavoriteNewsEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    var id: String,
    @ColumnInfo(name = "fields")
    var fields: FieldsDto?,
    @ColumnInfo(name = "webTitle")
    var webTitle: String?,
    @ColumnInfo(name = "type")
    var type: String?,
)

class FieldsTypeConverter {

    @TypeConverter
    fun fromSource(fields: FieldsDto): String? {
        return fields.body
    }

    @TypeConverter
    fun toSource(name: String): FieldsDto {
        return FieldsDto(name, name, name)
    }
}
