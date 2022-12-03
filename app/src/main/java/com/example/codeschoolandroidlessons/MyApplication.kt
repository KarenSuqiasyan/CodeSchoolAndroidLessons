package com.example.codeschoolandroidlessons

import com.example.BaseApplication
import com.example.codeschoolandroidlessons.guardianv2.di.mainModule
import com.example.codeschoolandroidlessons.guardianv2.ui.di.guardianModule
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiver
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiverListener
import org.koin.core.module.Module

class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun getKoinModules(): List<Module> = listOf(
        mainModule(),
        guardianModule
    )

    fun setConnectionListener(listener: ConnectionReceiverListener) {
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object {
        lateinit var instance: MyApplication
    }
}