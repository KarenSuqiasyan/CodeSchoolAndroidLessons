package com.example.codeschoolandroidlessons.guardian.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityGuardianNewsBinding
import com.example.codeschoolandroidlessons.guardian.data.repository.NewsRepositoryImpl
import com.example.codeschoolandroidlessons.guardian.BaseActivity
import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModelProviderFactory
import com.example.codeschoolandroidlessons.guardian.ui.contentnews.ContentNewsFragment
import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModel

class NewsActivity : BaseActivity() {

    private lateinit var binding: ActivityGuardianNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newsRepository = NewsRepositoryImpl()
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        replaceFragment(ContentNewsFragment.newInstance(), R.id.containerGuardian)
        checkNetworkConnection(binding.guardianNoInternetConnectionTextView)
    }
}