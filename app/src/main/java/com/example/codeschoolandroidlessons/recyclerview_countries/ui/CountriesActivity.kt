package com.example.codeschoolandroidlessons.recyclerview_countries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeschoolandroidlessons.databinding.ActivityCountriesBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CountryAdapter(CountriesEnum.values())
        binding.CountriesRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.CountriesRecyclerview.adapter = adapter

    }

}