package com.example.codeschoolandroidlessons.playmarket.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.ItemCategoriesGamesAppsBinding
import com.example.codeschoolandroidlessons.databinding.ItemForYouGamesBinding
import com.example.codeschoolandroidlessons.databinding.ItemTopChartsGamesAppsBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsCategoriesDto
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsForYouDto
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsTopChartsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameForYouDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameTopChartsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesCategoryDto

class MainAdapter : RecyclerView.Adapter<MainAdapter.BaseViewHolder>() {

    private val items: MutableList<Any> = mutableListOf()

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_TOP_CHARTS -> TopChartsItemViewHolder(ItemTopChartsGamesAppsBinding.inflate(layoutInflater, parent, false))
            VIEW_TYPE_GAMES_FOR_YOU -> GamesForYouItemViewHolder(ItemForYouGamesBinding.inflate(layoutInflater, parent, false))
            VIEW_TYPE_CATEGORIES -> CategoriesItemViewHolder(ItemCategoriesGamesAppsBinding.inflate(layoutInflater, parent, false))
            else -> throw IllegalArgumentException("undefined viewType: $viewType in ${this::class.java.simpleName}")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is AppsTopChartsDto, is GameTopChartsDto -> VIEW_TYPE_TOP_CHARTS
            is GameForYouDto -> VIEW_TYPE_GAMES_FOR_YOU
            is GamesCategoryDto, is AppsCategoriesDto -> VIEW_TYPE_CATEGORIES
//            is UrlPost -> MainAdapter.VIEW_TYPE_URL_POST
            else -> UNDEFINED
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Any>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: Any)
    }

    private inner class GamesForYouItemViewHolder(val binding: ItemForYouGamesBinding) : BaseViewHolder(binding.root) {

        override fun bind(item: Any) {
            when (item) {
                is GameForYouDto -> {
                    binding.nameTextView.text = item.title
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.mainForYouImageView)
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.secondaryForYouImageView)
                    binding.ratingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.text = item.memory.toString()
                }
                else -> {

                }
            }
        }
    }

    private inner class TopChartsItemViewHolder(val binding: ItemTopChartsGamesAppsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            when (item) {
                is GameForYouDto -> {
                    binding.topChartsTitleTextView.text = item.title
                    binding.topChartsNumberTextView.text = items[absoluteAdapterPosition + 1].toString()
                    binding.topChartsRatingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.text = item.memory.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.topChartsImageView)
                }
                is AppsForYouDto -> {
                    binding.topChartsTitleTextView.text = item.title
                    binding.topChartsNumberTextView.text = items[absoluteAdapterPosition + 1].toString()
                    binding.topChartsRatingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.text = item.memory.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.topChartsImageView)
                }
                else -> {
                }
            }
        }
    }
    private inner class CategoriesItemViewHolder(val binding: ItemCategoriesGamesAppsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            when (item) {
                is GameForYouDto -> {
                    binding.categoriesTextView.text = item.title
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.categoriesImageView)
                }
                is AppsForYouDto -> {
                    binding.categoriesTextView.text = item.title
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.categoriesImageView)
                }
                else -> {
                }
            }
        }
    }
    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TOP_CHARTS = 1
        private const val VIEW_TYPE_GAMES_FOR_YOU = 2
        private const val VIEW_TYPE_CATEGORIES = 3
//        private const val VIEW_TYPE_IMAGE_POST = 4
//
//        const val URL_FOR_WEB_VIEW = "url for web view"
//        const val FULL_SCREEN_IMAGE = "full screen image"
    }
}