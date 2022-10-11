package com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.ActivityCountryDetailsBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_DESCRIPTION
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_FLAG
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_TITLE

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailsTextView.text = intent.getStringExtra(COUNTRIES_ENUM_DESCRIPTION)
        binding.titleTextview2.text = intent.getStringExtra(COUNTRIES_ENUM_TITLE)
        Glide.with(this).load(intent.getStringExtra(COUNTRIES_ENUM_FLAG)).into(binding.flagImageview2)

    }
}