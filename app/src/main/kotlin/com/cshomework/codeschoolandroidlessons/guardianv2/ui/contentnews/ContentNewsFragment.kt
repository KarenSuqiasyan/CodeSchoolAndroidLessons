package com.cshomework.codeschoolandroidlessons.guardianv2.ui.contentnews

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.common.BaseCommonFragment
import com.common.codeschoolandroidlessons.databinding.FragmentGuardianContentNewsBinding
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.adapter.NewsAdapter
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.favoritesViewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class ContentNewsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentGuardianContentNewsBinding
    lateinit var newsAdapter: NewsAdapter
//    var isScrolling = false
    private val viewModel by lifecycleScope.viewModel<ContentNewsViewModel>(this)

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
//        setupListeners()
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        newsAdapter = NewsAdapter {
            navigateFragment(ContentNewsFragmentDirections.actionContentNewsFragmentToDetailsFragment(it))
        }
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
//            addOnScrollListener(this@ContentNewsFragment.scrollListener)
        }
    }

//    private fun setupListeners() {
//        scrollListener = object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//                val visibleItemCount = layoutManager.childCount
//                val totalItemCount = layoutManager.itemCount
//
//                val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
//                val isNotAtBeginning = firstVisibleItemPosition >= 0
//                val shouldPaginate = isAtLastItem && isNotAtBeginning && isScrolling
//                if (shouldPaginate) {
//                    isScrolling = false
//                }
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true
//                }
//            }
//        }
//        setupRecyclerView()
//    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeLiveData() {
        viewModel.resultsLiveData.observe(viewLifecycleOwner) { it ->
            it?.let { result ->
                newsAdapter.updateData(result)
            }
        }
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.notifyDataSetChanged()
        }
    }

//    private fun setupRecyclerView() {
//        newsAdapter = ContentNewsAdapter {
//            navigateFragment(ContentNewsFragmentDirections.actionContentNewsFragmentToDetailsFragment(it))
//        }
//        binding.contentNewsRecyclerView.apply {
//            adapter = newsAdapter
////            addOnScrollListener(this@ContentNewsFragment.scrollListener)
//        }
//    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }
}