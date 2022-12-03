package com.example.codeschoolandroidlessons.guardianv2.ui.activity

import android.os.Bundle
import com.example.base.BaseCommonActivity
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityGuardianNewsBinding
import com.example.codeschoolandroidlessons.guardianv2.ui.contentnews.ContentNewsFragment
//import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModel

class NewsActivity : BaseCommonActivity() {

    private lateinit var binding: ActivityGuardianNewsBinding
//    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ContentNewsFragment.newInstance(), R.id.containerGuardian)
        checkNetworkConnection(binding.guardianNoInternetConnectionTextView)
    }
}