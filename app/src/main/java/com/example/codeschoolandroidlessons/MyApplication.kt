package com.example.codeschoolandroidlessons

import android.app.Application
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiver

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun setConnectionListener (listener: ConnectionReceiver.ConnectionReceiverListener) {
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object {
        lateinit var instance: MyApplication
    }
}