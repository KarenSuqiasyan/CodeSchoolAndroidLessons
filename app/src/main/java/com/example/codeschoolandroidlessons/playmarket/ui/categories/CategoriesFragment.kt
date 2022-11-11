package com.example.codeschoolandroidlessons.playmarket.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentCategoriesBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsCategoriesDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesCategoryDto
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.MainAdapter

class CategoriesFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val adapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.categoriesRecyclerView.adapter = adapter
        adapter.updateData(
            GamesCategoryDto.values().toList(),
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoriesFragment()
    }
}