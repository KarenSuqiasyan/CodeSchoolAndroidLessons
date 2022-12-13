package com.cshomework.codeschoolandroidlessons.playmarket.utils.internet_connection

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class ConnectionReceiver : BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, p1: Intent?) {
        val isConnected = checkConnection(context)
        if (connectionReceiverListener != null) connectionReceiverListener?.onNetworkConnectionChange(isConnected)
    }

    companion object {
        var connectionReceiverListener: ConnectionReceiverListener? = null
    }

    private fun checkConnection(context: Context): Boolean {
        val result: Boolean
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
        return result
    }
}

interface ConnectionReceiverListener {
    fun onNetworkConnectionChange(isConnected: Boolean)
}