package com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrieslist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeschoolandroidlessons.databinding.ActivityCountriesBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.data.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails.CountryDetailsActivity


class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CountriesRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@CountriesActivity)
            adapter = CountryAdapter(CountriesEnum.values()) { action, country ->
                when (action) {
                    CountryAdapter.CountryActionEnum.ACTION_ITEM_CLICK -> {
                        val intent = Intent(this@CountriesActivity, CountryDetailsActivity::class.java)
                        intent.putExtra(CountryAdapter.COUNTRIES_ENUM_DESCRIPTION, country.description)
                        intent.putExtra(CountryAdapter.COUNTRIES_ENUM_TITLE, country.title)
                        intent.putExtra(CountryAdapter.COUNTRIES_ENUM_FLAG, country.flagUrl)
                        startActivity(intent)
                    }
                    CountryAdapter.CountryActionEnum.ACTION_FLAG_CLICK -> {
                        val intent = Intent(this@CountriesActivity, CountryDetailsActivity::class.java)
                        intent.putExtra(CountryAdapter.COUNTRIES_ENUM_FLAG2, country.flagUrl)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}