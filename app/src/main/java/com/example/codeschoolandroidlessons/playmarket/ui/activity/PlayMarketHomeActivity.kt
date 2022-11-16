package com.example.codeschoolandroidlessons.playmarket.ui.activity

import android.os.Bundle
import androidx.core.view.isVisible
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityPlayMarketHomeBinding
import com.example.codeschoolandroidlessons.playmarket.ui.base.activity.BasePlayMarketActivity
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.AppsMainTabFragment
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.GamesMainTabFragment
import com.example.codeschoolandroidlessons.playmarket.utils.internet_connection.InternetReceiver


class PlayMarketHomeActivity : BasePlayMarketActivity() {

    private lateinit var binding: ActivityPlayMarketHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayMarketHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        internetConnectionLost()
        binding.homeBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_apps -> replaceFragment(AppsMainTabFragment.newInstance(), R.id.homeContainerLayout)
                R.id.navigation_games -> replaceFragment(GamesMainTabFragment.newInstance(), R.id.homeContainerLayout)
            }
            true
        }
        binding.homeBottomNavigation.selectedItemId = R.id.navigation_games
    }

    private fun internetConnectionLost() {
        binding.noInternetConnectionTextView.isVisible = !InternetReceiver.isNetworkAvailable(this)
    }
}