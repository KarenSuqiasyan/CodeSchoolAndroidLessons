package com.example.codeschoolandroidlessons.playmarket.ui.for_you

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentForYouBinding
import com.example.codeschoolandroidlessons.playmarket.FragmentTypeEnum
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsForYouDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameForYouDto
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.GlobalScrollAdapter

class ForYouFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentForYouBinding
    private var mFragmentTypeEnum = fragmentTypeEnum

    private val adapter = GlobalScrollAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForYouBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.forYouRecyclerView.adapter = adapter
        adapter.updateData(
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