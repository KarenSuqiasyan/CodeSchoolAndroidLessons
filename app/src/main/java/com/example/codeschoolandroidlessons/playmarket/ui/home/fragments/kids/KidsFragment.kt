package com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.FragmentPlaymarketKidsBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsKidsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesKidsDto
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.NestedScrollAdapter
import com.example.codeschoolandroidlessons.playmarket.ui.base.fragment.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.home.fragments.FragmentTypeEnum

class KidsFragment(fragmentTypeEnum: FragmentTypeEnum) : BasePlayMarketFragment() {

    private lateinit var binding: FragmentPlaymarketKidsBinding
    private var mFragmentTypeEnum = fragmentTypeEnum

    private val nestedAdapter: NestedScrollAdapter by lazy {
        NestedScrollAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaymarketKidsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.kidsRecyclerView.adapter = nestedAdapter
        Glide.with(requireActivity()).load("https://cdn.wallpapersafari.com/2/29/oWJgyU.jpg").centerCrop().into(binding.kidsBackgroundImageView)
        nestedAdapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.GAMES -> listOf(
                    GamesKidsDto.values().toList(),
                    GamesKidsDto.values().toList(),
                    GamesKidsDto.values().toList(),
                    GamesKidsDto.values().toList()

                )
                FragmentTypeEnum.APPS -> listOf(
                    AppsKidsDto.values().toList(),
                    AppsKidsDto.values().toList(),
                    AppsKidsDto.values().toList(),
                    AppsKidsDto.values().toList()
                )
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = KidsFragment(fragmentTypeEnum)
    }
}