package com.cshomework.codeschoolandroidlessons

import com.common.BaseCommonApplication
import com.common.guardian.news.di.newsModule
//import com.cshomework.codeschoolandroidlessons.guardianv2.di.mainModule
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.di.guardianModule
import com.cshomework.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiver
import com.cshomework.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiverListener
import org.koin.core.module.Module

class CodeSchoolLessonsApplication : BaseCommonApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun getKoinModules(): List<Module> = listOf(
//        mainModule(),
        newsModule(),
        guardianModule,

        )

    fun setConnectionListener(listener: ConnectionReceiverListener) {
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object {
        lateinit var instance: CodeSchoolLessonsApplication
    }
}