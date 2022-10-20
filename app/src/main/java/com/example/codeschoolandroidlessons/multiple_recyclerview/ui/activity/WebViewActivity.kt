package com.example.codeschoolandroidlessons.multiple_recyclerview.ui.activity

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.databinding.ActivityWebViewBinding
import com.example.codeschoolandroidlessons.multiple_recyclerview.ui.adapter.PostAdapter

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra(PostAdapter.URL_FOR_WEB_VIEW)

        binding.webView.apply {
            webViewClient = WebViewClient()
            if (url != null) {
                loadUrl(url)
            }
            settings.setSupportZoom(true)
        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack())
            binding.webView.goBack()
        else
            super.onBackPressed()
    }
}