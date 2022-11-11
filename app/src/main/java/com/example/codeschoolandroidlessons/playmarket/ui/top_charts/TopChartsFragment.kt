package com.example.codeschoolandroidlessons.playmarket.ui.top_charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codeschoolandroidlessons.databinding.FragmentTopChartsBinding
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameTopChartsDto
import com.example.codeschoolandroidlessons.playmarket.ui.BasePlayMarketFragment
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.MainAdapter

class TopChartsFragment : BasePlayMarketFragment() {

    private lateinit var binding: FragmentTopChartsBinding
    private val adapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopChartsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.topChartsRecyclerView.adapter = adapter
        adapter.updateData(
            GameTopChartsDto.values().toList()
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = TopChartsFragment()
    }
}