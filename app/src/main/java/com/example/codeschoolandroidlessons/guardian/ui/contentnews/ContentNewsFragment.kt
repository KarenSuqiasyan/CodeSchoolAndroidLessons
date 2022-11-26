package com.example.codeschoolandroidlessons.guardian.ui.contentnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codeschoolandroidlessons.databinding.FragmentGuardianContentNewsBinding
import com.example.codeschoolandroidlessons.guardian.BaseFragment
import com.example.codeschoolandroidlessons.guardian.util.Resource

class ContentNewsFragment : BaseFragment() {

    private lateinit var binding: FragmentGuardianContentNewsBinding
    lateinit var newsAdapter: ContentNewsAdapter
    var isScrolling = false
    private lateinit var scrollListener: RecyclerView.OnScrollListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getContentNews()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGuardianContentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeLiveData()
    }

    private fun setupListeners() {
        scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
                val isNotAtBeginning = firstVisibleItemPosition >= 0
                val shouldPaginate = isAtLastItem && isNotAtBeginning && isScrolling
                if (shouldPaginate) {
                    viewModel.getContentNews()
                    isScrolling = false
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }
        }
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            Toast.makeText(requireContext(), "${it.sectionName} is clicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun observeLiveData() {
        viewModel.contentNews.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar(binding.progressBar)
                    response.data?.let { newsResponse ->
                        newsAdapter.updateData(newsResponse.response.results.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar(binding.progressBar)
                    response.message?.let { message ->
                        Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar(binding.progressBar)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = ContentNewsAdapter()
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@ContentNewsFragment.scrollListener)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }
}