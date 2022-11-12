package com.example.codeschoolandroidlessons.playmarket.ui.kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentKidsBinding
import com.example.codeschoolandroidlessons.playmarket.FragmentTypeEnum
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsKidsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesKidsDto
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.GlobalScrollAdapter

class KidsFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentKidsBinding
    private val adapter = GlobalScrollAdapter()
    private var mFragmentTypeEnum = fragmentTypeEnum


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKidsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.kidsRecyclerView.adapter = adapter
        adapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.GAMES -> listOf(
                    AppsKidsDto.values().toList(),
                )
                FragmentTypeEnum.APPS -> listOf(
                    GamesKidsDto.values().toList(),
                )
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = KidsFragment(fragmentTypeEnum)
    }
}