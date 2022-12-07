package com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.common.codeschoolandroidlessons.databinding.ItemCountriesBinding
import com.cshomework.codeschoolandroidlessons.recyclerview_countries.data.model.CountriesEnum

class CountryAdapter(var countries: Array<CountriesEnum>, private val countryItemClickListener: (CountryActionEnum, CountriesEnum) -> Unit) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    inner class CountryViewHolder(private val binding: ItemCountriesBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { countryItemClickListener(CountryActionEnum.ACTION_ITEM_CLICK, countries[absoluteAdapterPosition]) }
            binding.flagImageview.setOnClickListener { countryItemClickListener(CountryActionEnum.ACTION_FLAG_CLICK, countries[absoluteAdapterPosition]) }
            binding.titleTextview.setOnLongClickListener {
                val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                clipboardManager.setPrimaryClip(ClipData.newPlainText(LABEL, binding.titleTextview.text))
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
                false
            }
        }
        fun bind(countriesEnum: CountriesEnum) {
            binding.titleTextview.text = countriesEnum.title
            binding.descriptionTextview.text = countriesEnum.shortDescription
            Glide.with(context).load(countriesEnum.flagUrl).into(binding.flagImageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(ItemCountriesBinding.inflate(layoutInflater, parent, false))


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    companion object {
        const val COUNTRIES_ENUM_DESCRIPTION = "CountriesEnumDescription"
        const val COUNTRIES_ENUM_TITLE = "CountriesEnumTitle"
        const val COUNTRIES_ENUM_FLAG = "CountriesEnumFlag"
        const val COUNTRIES_ENUM_FLAG2 = "CountriesEnumFlag2"

        const val LABEL = "label"
    }

    enum class CountryActionEnum {
        ACTION_ITEM_CLICK,
        ACTION_FLAG_CLICK
    }
}

