package com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.top_charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentPlaymarketTopChartsBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsCategoriesDto
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsTopChartsDto
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsTopChartsTopFreeDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameTopChartsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesTopChartsTopFreeDto
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.BaseAdapter
import com.example.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum

class TopChartsFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketTopChartsBinding
    private var mFragmentTypeEnum = fragmentTypeEnum
    private val baseAdapter: BaseAdapter by lazy {
        BaseAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaymarketTopChartsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        val bottomSheetTopChartsCategoriesFragment = BottomSheetFragmentDialog.newInstance(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppsCategoriesDto.values().toMutableList()
                FragmentTypeEnum.GAMES -> AppsCategoriesDto.values().toMutableList()
            }
        )
        val bottomSheetTopChartsTopFreeFragment = BottomSheetFragmentDialog.newInstance(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppsTopChartsTopFreeDto.values().toMutableList()
                FragmentTypeEnum.GAMES -> GamesTopChartsTopFreeDto.values().toMutableList()
            }
        )
        binding.topChartsCategoriesButton.setOnClickListener {
            bottomSheetTopChartsCategoriesFragment.show(requireActivity().supportFragmentManager, bottomSheetTopChartsCategoriesFragment.tag)
        }
        binding.topChartsTopFreeButton.setOnClickListener {
            bottomSheetTopChartsTopFreeFragment.show(requireActivity().supportFragmentManager, bottomSheetTopChartsCategoriesFragment.tag)
        }
    }

    private fun setupViews() {
        binding.topChartsRecyclerView.adapter = baseAdapter
        baseAdapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppsTopChartsDto.values().toList()
                FragmentTypeEnum.GAMES -> GameTopChartsDto.values().toList()
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = TopChartsFragment(fragmentTypeEnum)
    }
}