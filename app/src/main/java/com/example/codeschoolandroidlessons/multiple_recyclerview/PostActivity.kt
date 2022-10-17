package com.example.codeschoolandroidlessons.multiple_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeschoolandroidlessons.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<Any>()
        items.add(TextPost("hello"))
//        items.add(VideoPost("https://player.vimeo.com/video/71787467"))
//        items.add(UrlPost("https://films.bz/serial/136-anamotnery.html"))
        items.add(ImagePost("https://image.shutterstock.com/image-illustration/flag-brazil-beautiful-wrinkle-cloth-600w-1928399681"))
//        items.add(UrlPost("https://films.bz/serial/29836-friends.html"))
//        items.add(ImagePost("https://image.shutterstock.com/image-illustration/flag-brazil-beautiful-wrinkle-cloth-600w-1928399681"))

        val postAdapter = PostAdapter()
        postAdapter.updateData(items)

        binding.PostRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            adapter = postAdapter
        }
    }
}