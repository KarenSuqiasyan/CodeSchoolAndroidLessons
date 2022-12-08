package com.cshomework.codeschoolandroidlessons.guardianv2.ui.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.common.BaseCommonActivity
import com.common.codeschoolandroidlessons.R
import com.common.codeschoolandroidlessons.databinding.ActivityGuardianNewsBinding


class NewsActivity : BaseCommonActivity() {

    private lateinit var binding: ActivityGuardianNewsBinding
    override fun noInternetView(): View = binding.noInternetTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(this.findNavController(R.id.navHostFragment))
    }
}