package com.example.codeschoolandroidlessons.guardian.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityNewsBinding
import com.example.codeschoolandroidlessons.guardian.data.repository.NewsRepository
import com.example.codeschoolandroidlessons.guardian.ui.BaseActivity
import com.example.codeschoolandroidlessons.guardian.ui.NewsViewModelProviderFactory
import com.example.codeschoolandroidlessons.guardian.ui.fragment.ContentNewsFragment
import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModel

class NewsActivity : BaseActivity() {

    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newsRepository = NewsRepository()
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        replaceFragment(ContentNewsFragment.newInstance(), R.id.containerGuardian)
    }
}