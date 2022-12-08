package com.common.guardian.favorite.di

import com.common.guardian.favorite.database.FavoriteDatabase
import com.common.guardian.favorite.repository.FavoriteNewsRepository
import com.common.guardian.favorite.repository.FavoriteNewsRepositoryImpl
import org.koin.dsl.module

val favoriteNewsModule = module {
    single { get<FavoriteDatabase>().favoriteNewsDao() }
    single<FavoriteNewsRepository> { FavoriteNewsRepositoryImpl(get()) }
//    single { FavoriteDatabase(get()) }
}