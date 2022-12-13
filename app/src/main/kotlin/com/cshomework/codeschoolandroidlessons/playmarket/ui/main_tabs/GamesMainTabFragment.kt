package com.cshomework.codeschoolandroidlessons.playmarket.ui.main_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.common.codeschoolandroidlessons.R
import com.common.codeschoolandroidlessons.databinding.FragmentPlaymarketGamesMainTabBinding
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.categories.CategoriesFragment
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.for_you.ForYouFragment
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.kids.KidsFragment
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.top_charts.TopChartsFragment
import com.google.android.material.tabs.TabLayoutMediator

class GamesMainTabFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketGamesMainTabBinding
    private val tabFragments = mutableListOf<BasePlayMarketFragment>(
        ForYouFragment.newInstance(FragmentTypeEnum.GAMES),
        TopChartsFragment.newInstance(FragmentTypeEnum.GAMES),
        KidsFragment.newInstance(FragmentTypeEnum.GAMES),
        CategoriesFragment.newInstance(FragmentTypeEnum.GAMES)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPlaymarketGamesMainTabBinding.inflate(inflater, container, false)
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