package com.example.codeschoolandroidlessons.playmarket.ui.base.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.MyApplication
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiver
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.ConnectionReceiverListener

abstract class BasePlayMarketActivity : AppCompatActivity(), ConnectionReceiverListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseContext.registerReceiver(ConnectionReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        MyApplication.instance.setConnectionListener(this)
    }
    fun replaceFragment(fragment: Fragment, resId: Int) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val menuItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Search for apps and games"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}