package com.example.codeschoolandroidlessons.playmarket.ui.home.activity

import android.os.Bundle
import androidx.core.view.isVisible
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityPlaymarketHomeBinding
import com.example.codeschoolandroidlessons.playmarket.ui.base.activity.BasePlayMarketActivity
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.AppsMainTabFragment
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.GamesMainTabFragment


class PlayMarketHomeActivity : BasePlayMarketActivity() {

    private lateinit var binding: ActivityPlaymarketHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaymarketHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.homeBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_apps -> replaceFragment(AppsMainTabFragment.newInstance(), R.id.homeContainerLayout)
                R.id.navigation_games -> replaceFragment(GamesMainTabFragment.newInstance(), R.id.homeContainerLayout)
            }
            true
        }
        binding.homeBottomNavigation.selectedItemId = R.id.navigation_games
    }

    override fun onNetworkConnectionChange(isConnected: Boolean) {
        binding.noInternetConnectionTextView.isVisible = !isConnected
    }
}