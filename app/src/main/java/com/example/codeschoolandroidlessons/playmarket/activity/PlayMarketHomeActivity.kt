package com.example.codeschoolandroidlessons.playmarket.activity

import android.os.Bundle
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketActivity
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityPlayMarketHomeBinding
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.AppsMainTabFragment
import com.example.codeschoolandroidlessons.playmarket.ui.main_tabs.GamesMainTabFragment

class PlayMarketHomeActivity : BasePlayMarketActivity() {

    private lateinit var binding: ActivityPlayMarketHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayMarketHomeBinding.inflate(layoutInflater)
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
}