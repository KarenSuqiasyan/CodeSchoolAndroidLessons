package com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.ItemCountriesBinding
import com.example.codeschoolandroidlessons.recyclerview_countries.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails.CountryDetailsActivity

class CountryAdapter(var counties: Array<CountriesEnum>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    inner class CountryViewHolder(private val binding: ItemCountriesBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("CheckResult")
        fun bind(countriesEnum: CountriesEnum) {
            binding.titleTextview.text = countriesEnum.title
            binding.descriptionTextview.text = countriesEnum.shortDescription
            Glide.with(context).load(countriesEnum.flagUrl).into(binding.flagImageview)
            binding.root.setOnClickListener {
                val intent = Intent(context, CountryDetailsActivity::class.java)
                intent.putExtra(COUNTRIES_ENUM_DESCRIPTION, countriesEnum.description)
                intent.putExtra(COUNTRIES_ENUM_TITLE, countriesEnum.title)
                intent.putExtra(COUNTRIES_ENUM_FLAG, countriesEnum.flagUrl)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder = CountryViewHolder(ItemCountriesBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val countriesEnum = counties[position]
        holder.bind(countriesEnum)
    }

    override fun getItemCount() = counties.size

    companion object {
        const val COUNTRIES_ENUM_DESCRIPTION = "CountriesEnumDescription"
        const val COUNTRIES_ENUM_TITLE = "CountriesEnumTitle"
        const val COUNTRIES_ENUM_FLAG = "CountriesEnumFlag"
    }
}

