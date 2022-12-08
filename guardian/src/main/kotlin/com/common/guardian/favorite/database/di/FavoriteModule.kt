package com.common.guardian.favorite.database.di

import androidx.room.Room
import com.common.guardian.favorite.database.FavoriteDatabase
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(get(), FavoriteDatabase::class.java, "guardian_database")
            .build()
    }
}