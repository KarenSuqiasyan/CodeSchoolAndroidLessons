package com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.for_you

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.codeschoolandroidlessons.databinding.FragmentPlaymarketForYouBinding
import com.cshomework.codeschoolandroidlessons.playmarket.data.apps_model.AppsForYouDto
import com.cshomework.codeschoolandroidlessons.playmarket.data.games_model.GameForYouDto
import com.cshomework.codeschoolandroidlessons.playmarket.ui.adapters.NestedScrollAdapter
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum

class ForYouFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketForYouBinding
    private var mFragmentTypeEnum = fragmentTypeEnum
    private val nestedAdapter: NestedScrollAdapter by lazy {
        NestedScrollAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaymarketForYouBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.forYouRecyclerView.adapter = nestedAdapter
        nestedAdapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.GAMES -> listOf(
                    GameForYouDto.values().toList(),
                    GameForYouDto.values().toList(),
                    GameForYouDto.values().toList(),
                    GameForYouDto.values().toList()
                )
                FragmentTypeEnum.APPS -> listOf(
                    AppsForYouDto.values().toList(),
                    AppsForYouDto.values().toList(),
                    AppsForYouDto.values().toList(),
                    AppsForYouDto.values().toList()
                )
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = ForYouFragment(fragmentTypeEnum)
    }
}