package com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrieslist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityCountriesBinding
import com.example.codeschoolandroidlessons.databinding.ImageDialogBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails.CountryDetailsActivity


class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    private lateinit var dialogBinding: ImageDialogBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        dialogBinding = ImageDialogBinding.inflate(layoutInflater)
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
                        Glide.with(this@CountriesActivity).load(country.flagUrl).into(dialogBinding.dialogImageView)
                        val mBuilder = AlertDialog.Builder(this@CountriesActivity, R.layout.image_dialog)
                            .setPositiveButton("ok", null)
                        val mAlertDialog = mBuilder.create()
                        mAlertDialog.show()
//                        binding.fullscreenImageView.isVisible = true
//                        Glide.with(context).load(country.flagUrl).into(binding.fullscreenImageView)
                    }
                }
            }
        }
    }
}