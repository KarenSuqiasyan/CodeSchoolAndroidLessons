package com.example.codeschoolandroidlessons.playmarket.ui.main_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.FragmentGamesMainTabBinding
import com.example.codeschoolandroidlessons.playmarket.FragmentTypeEnum
import com.example.codeschoolandroidlessons.playmarket.ui.categories.CategoriesFragment
import com.example.codeschoolandroidlessons.playmarket.ui.for_you.ForYouFragment
import com.example.codeschoolandroidlessons.playmarket.ui.kids.KidsFragment
import com.example.codeschoolandroidlessons.playmarket.ui.top_charts.TopChartsFragment
import com.google.android.material.tabs.TabLayoutMediator

class GamesMainTabFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentGamesMainTabBinding
    private val tabFragments = mutableListOf<BasePlayMarketFragment>(
        CategoriesFragment.newInstance(FragmentTypeEnum.GAMES),
        ForYouFragment.newInstance(FragmentTypeEnum.GAMES),
        KidsFragment.newInstance(FragmentTypeEnum.GAMES),
        TopChartsFragment.newInstance(FragmentTypeEnum.GAMES)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGamesMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupStringResources()
    }

    private fun setupViews() {
        binding.viewPager.apply {
            adapter = object : FragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle) {
                override fun createFragment(position: Int) = tabFragments[position]

                override fun getItemCount(): Int = tabFragments.size
            }
            isUserInputEnabled = false
        }
    }

    private fun setupStringResources() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager, true) { tab, position ->
            when (tabFragments[position]) {
                is CategoriesFragment -> tab.text = getString(R.string.categories)
                is ForYouFragment -> tab.text = getString(R.string.for_you)
                is KidsFragment -> tab.text = getString(R.string.kids)
                is TopChartsFragment -> tab.text = getString(R.string.top_charts)
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = GamesMainTabFragment()
    }
}