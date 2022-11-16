package com.example.codeschoolandroidlessons.playmarket.ui.main_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.FragmentPlaymarketAppsMainTabBinding
import com.example.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.categories.CategoriesFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.for_you.ForYouFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.kids.KidsFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.top_charts.TopChartsFragment
import com.google.android.material.tabs.TabLayoutMediator

class AppsMainTabFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketAppsMainTabBinding
    private val tabFragments = mutableListOf<BasePlayMarketFragment>(
        ForYouFragment.newInstance(FragmentTypeEnum.APPS),
        TopChartsFragment.newInstance(FragmentTypeEnum.APPS),
        KidsFragment.newInstance(FragmentTypeEnum.APPS),
        CategoriesFragment.newInstance(FragmentTypeEnum.APPS)

    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPlaymarketAppsMainTabBinding.inflate(inflater, container, false)
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
                is ForYouFragment -> tab.text = getString(R.string.for_you)
                is TopChartsFragment -> tab.text = getString(R.string.top_charts)
                is KidsFragment -> tab.text = getString(R.string.kids)
                is CategoriesFragment -> tab.text = getString(R.string.categories)
            }
        }.attach()
    }


    companion object {
        @JvmStatic
        fun newInstance() = AppsMainTabFragment()
    }
}
