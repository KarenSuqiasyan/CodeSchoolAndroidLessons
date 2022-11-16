package com.example.codeschoolandroidlessons.playmarket.ui.base.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.InternetReceiver

open class BasePlayMarketActivity : AppCompatActivity() {
    lateinit var broadcastReceiver: InternetReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        broadcastReceiver = InternetReceiver()
        internetStatus()
    }

    fun replaceFragment(fragment: Fragment, resId: Int) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }

    private fun internetStatus() {
        registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
    }
}