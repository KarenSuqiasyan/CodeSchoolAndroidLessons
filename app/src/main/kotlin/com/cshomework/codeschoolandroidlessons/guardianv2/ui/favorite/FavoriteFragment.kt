package com.cshomework.codeschoolandroidlessons.guardianv2.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.BaseCommonFragment
import com.common.codeschoolandroidlessons.databinding.FragmentFavoriteBinding
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.adapter.NewsAdapter
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.favoritesViewModel

class FavoriteFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentFavoriteBinding
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        newsAdapter = NewsAdapter {
            navigateFragment(FavoriteFragmentDirections.actionContentNewsFragmentToDetailsFragment(it))
        }
        binding.favoriteRecyclerView.apply {
            adapter = newsAdapter
        }
    }

    private fun observeLiveData() {
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.updateData(it)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = FavoriteFragment()
    }
}