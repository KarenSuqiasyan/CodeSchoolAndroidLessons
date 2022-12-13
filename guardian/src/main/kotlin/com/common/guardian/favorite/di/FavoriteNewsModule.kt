package com.common.guardian.favorite.di

import androidx.room.Room
import com.common.guardian.favorite.database.FavoriteDatabase
import com.common.guardian.favorite.database.dao.FavoriteNewsDao
import com.common.guardian.favorite.repository.FavoriteNewsRepository
import com.common.guardian.favorite.repository.FavoriteNewsRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val favoriteNewsModule = module {
    single { get<FavoriteDatabase>().favoriteNewsDao() }
    single<FavoriteNewsRepository> { FavoriteNewsRepositoryImpl(get()) }
}