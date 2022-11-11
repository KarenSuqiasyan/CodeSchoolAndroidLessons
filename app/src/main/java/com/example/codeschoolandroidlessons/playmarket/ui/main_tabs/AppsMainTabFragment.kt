package com.example.codeschoolandroidlessons.playmarket.ui.main_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.databinding.FragmentAppsMainTabBinding
import com.example.codeschoolandroidlessons.playmarket.ui.categories.CategoriesFragment
import com.example.codeschoolandroidlessons.playmarket.ui.for_you.ForYouFragment
import com.example.codeschoolandroidlessons.playmarket.ui.kids.KidsFragment
import com.example.codeschoolandroidlessons.playmarket.ui.top_charts.TopChartsFragment

class AppsMainTabFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentAppsMainTabBinding
    private val tabFragments = mutableListOf<BasePlayMarketFragment>(
        CategoriesFragment.newInstance(),
        ForYouFragment.newInstance(),
        KidsFragment.newInstance(),
        TopChartsFragment.newInstance()
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAppsMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupStringResources()
    }

    private fun setupViews() {
//        binding.apply {
//            adapter = object : FragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle) {
//                override fun createFragment(position: Int) = tabFragments[position]
//
//                override fun getItemCount(): Int = tabFragments.size
//            }
//            isUserInputEnabled = false
//        }
//
//        TabLayoutMediator(binding.tabLayout, binding.viewPager, true) { tab, position ->
//            when (tabFragments[position]) {
//                is CategoryGamesFragment -> tab.text = getStringByKey(R.string.gamePage_casinoTabName)
//                is LiveCasinoFragment -> tab.text = getStringByKey(R.string.gamePage_liveCasinoTabName)
//            }
//        }.attach()
    }

    private fun setupStringResources() {
//        binding.bonusBalanceCustomView.setupLocalizedStringResources()
//        TabLayoutMediator(binding.tabLayout, binding.viewPager, true) { tab, position ->
//            when (tabFragments[position]) {
//                is CategoryGamesFragment -> tab.text = getStringByKey(R.string.gamePage_casinoTabName)
//                is LiveCasinoFragment -> tab.text = getStringByKey(R.string.gamePage_liveCasinoTabName)
//            }
//        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AppsMainTabFragment()
    }
}