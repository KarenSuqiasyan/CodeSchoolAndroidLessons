package com.example.codeschoolandroidlessons.multiple_recyclerview.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityPostBinding
import com.example.codeschoolandroidlessons.databinding.ItemTextBinding
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.DB
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.ImagePost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.TextPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.UrlPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.VideoPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.ui.adapter.PostAdapter
import com.example.codeschoolandroidlessons.multiple_recyclerview.utils.Utils

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val items = DB.getData()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterClick()

        binding.PostRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
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
                    val intent = Intent(this@PostActivity, WebViewActivity::class.java)
                    intent.putExtra(PostAdapter.URL_FOR_WEB_VIEW, post.url)
                    startActivity(intent)
                }
                PostAdapter.PostActionEnum.ACTION_IMAGE_ITEM_CLICK -> {
                    post as ImagePost

                    val intent = Intent(this@PostActivity, FullScreenImageActivity::class.java)
                    intent.putExtra(PostAdapter.FULL_SCREEN_IMAGE, post.imageUrl)
                    startActivity(intent)
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_TEXT -> {
                    post as TextPost
                    Utils.share(this, post.text, "text/plain")
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_IMAGE -> {
                    post as ImagePost
                    Utils.share(this, post.imageUrl, "image/jpeg")
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_VIDEO -> {
                    post as VideoPost
                    Utils.share(this, post.videoUrl, "image/jpeg")
                }
                PostAdapter.PostActionEnum.ACTION_SHARE_URL -> {
                    post as UrlPost
                    Utils.share(this, post.url, "image/jpeg")
                }
            }
        }
        postAdapter.updateData(items)
    }
}