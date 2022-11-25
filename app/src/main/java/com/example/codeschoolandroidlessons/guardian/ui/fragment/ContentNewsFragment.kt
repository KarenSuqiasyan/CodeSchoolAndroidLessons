package com.example.codeschoolandroidlessons.guardian.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeschoolandroidlessons.databinding.FragmentContentNewsBinding
import com.example.codeschoolandroidlessons.guardian.ui.activity.NewsActivity
import com.example.codeschoolandroidlessons.guardian.util.Constants.QUERY_PAGE_SIZE
import com.example.codeschoolandroidlessons.guardian.util.Resource
import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModel

class ContentNewsFragment : Fragment() {

    private lateinit var binding: FragmentContentNewsBinding
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: ContentNewsAdapter
    var isLastPage = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        viewModel.contentNewsCall()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentContentNewsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        viewModel.contentNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { newsResponse ->
                        newsAdapter.updateData(newsResponse.response.results)
                        val totalPages = newsResponse.response.pageSize / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.contentNewsPage == totalPages
                        if (isLastPage) {
                            binding.contentNewsRecyclerView.setPadding(0, 0, 0, 0)
                        }
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG).show()
                    }
                }
                else -> {}
            }
        })
        return binding.root
    }

    private fun setupRecyclerView() {
        newsAdapter = ContentNewsAdapter()
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }
}