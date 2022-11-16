package com.example.codeschoolandroidlessons

import android.app.Application
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiver
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiverListener

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun setConnectionListener (listener: ConnectionReceiverListener) {
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object {
        lateinit var instance: MyApplication
    }
}