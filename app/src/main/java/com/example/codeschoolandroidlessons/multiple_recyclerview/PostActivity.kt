package com.example.codeschoolandroidlessons.multiple_recyclerview

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityPostBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.data.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails.CountryDetailsActivity

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<Any>()
        items.add(TextPost("hello"))
        items.add(VideoPost("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4"))
//        items.add(VideoPost("https://player.vimeo.com/video/71787467"))
//        items.add(UrlPost("https://films.bz/serial/136-anamotnery.html"))
        items.add(ImagePost("https://media.istockphoto.com/vectors/vector-flag-of-brazil-proportion-710-brazilian-national-flag-vector-id967321044?k=20&m=967321044&s=612x612&w=0&h=PiLcSCJ7UzJkXOC3RhNw4WUQouAUwmkms5m7F7Ff9qA="))
//        items.add(UrlPost("https://films.bz/serial/29836-friends.html"))
//        items.add(ImagePost("https://image.shutterstock.com/image-illustration/flag-brazil-beautiful-wrinkle-cloth-600w-1928399681"))

          postAdapter = PostAdapter(items) { action, post ->
            when (action) {
                PostAdapter.PostActionEnum.ACTION_ITEM_CLICK -> {

                }
                PostAdapter.PostActionEnum.ACTION_IMAGE_CLICK -> {
                    post as ImagePost
                    val builder = Dialog(this@PostActivity)
                    builder.setContentView(R.layout.image_dialog)
                    builder.show()
                    Glide.with(this@PostActivity).load(post.imageUrl).into(builder.findViewById(R.id.dialogImageView))
//                        val intent = Intent(this@CountriesActivity, CountryDetailsActivity::class.java)
//                        intent.putExtra(CountryAdapter.COUNTRIES_ENUM_FLAG2, country.flagUrl)
//                        startActivity(intent)
                }
            }
        }


        binding.PostRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            adapter = postAdapter
        }
        postAdapter.updateData(items)
    }
}