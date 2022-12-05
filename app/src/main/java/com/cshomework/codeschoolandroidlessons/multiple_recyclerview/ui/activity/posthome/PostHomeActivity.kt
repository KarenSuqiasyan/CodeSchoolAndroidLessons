package com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.activity.posthome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.common.codeschoolandroidlessons.databinding.ActivityPostBinding
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.data.DB
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.data.model.ImagePost
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.data.model.TextPost
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.data.model.UrlPost
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.data.model.VideoPost
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.activity.fullscreenimage.FullScreenImageActivity
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.activity.webview.WebViewActivity
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.adapter.PostAdapter
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.utils.Utils

class PostHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val items = DB.getData()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterClick()

        binding.PostRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PostHomeActivity)
            adapter = postAdapter
        }
        postAdapter.updateData(items)
    }

    @SuppressLint("SetTextI18n")
    private fun adapterClick() {
        postAdapter = PostAdapter { action, post ->
            when (action) {
                PostAdapter.PostActionEnum.ACTION_URL_ITEM_CLICK -> {
                    post as UrlPost
                    val intent = Intent(this@PostHomeActivity, WebViewActivity::class.java)
                    intent.putExtra(PostAdapter.URL_FOR_WEB_VIEW, post.url)
                    startActivity(intent)
                }
                PostAdapter.PostActionEnum.ACTION_IMAGE_ITEM_CLICK -> {
                    post as ImagePost

                    val intent = Intent(this@PostHomeActivity, FullScreenImageActivity::class.java)
                    intent.putExtra(PostAdapter.FULL_SCREEN_IMAGE, post.imageUrl)
                    startActivity(intent)
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_TEXT -> {
                    post as TextPost
                    Utils.share(this, post.text, SHARE_TEXT)
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_IMAGE -> {
                    post as ImagePost
                    Utils.share(this, post.imageUrl, SHARE_LINK)
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_VIDEO -> {
                    post as VideoPost
                    Utils.share(this, post.videoUrl, SHARE_LINK)
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_URL -> {
                    post as UrlPost
                    Utils.share(this, post.url, SHARE_LINK)
                }
            }
        }
        postAdapter.updateData(items)
    }

    companion object {
        private const val SHARE_TEXT = "text/plain"
        private const val SHARE_LINK = "image/jpeg"
    }
}