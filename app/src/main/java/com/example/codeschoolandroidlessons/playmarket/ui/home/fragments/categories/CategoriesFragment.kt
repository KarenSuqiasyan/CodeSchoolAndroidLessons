package com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentPlaymarketCategoriesBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsCategoriesDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesCategoryDto
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.BaseAdapter
import com.example.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum

class CategoriesFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketCategoriesBinding
    private val mFragmentTypeEnum: FragmentTypeEnum = fragmentTypeEnum
    private val baseAdapter: BaseAdapter by lazy {
        BaseAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaymarketCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.categoriesRecyclerView.adapter = baseAdapter

        baseAdapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppsCategoriesDto.values().toList()
                FragmentTypeEnum.GAMES -> GamesCategoryDto.values().toList()
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = CategoriesFragment(fragmentTypeEnum)
    }
}