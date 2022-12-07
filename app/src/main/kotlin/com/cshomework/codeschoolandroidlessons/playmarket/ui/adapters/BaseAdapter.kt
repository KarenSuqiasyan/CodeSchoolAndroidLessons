package com.cshomework.codeschoolandroidlessons.playmarket.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.common.codeschoolandroidlessons.databinding.ItemPlaymarketCategoriesGamesAppsBinding
import com.common.codeschoolandroidlessons.databinding.ItemPlaymarketForYouGamesBinding
import com.common.codeschoolandroidlessons.databinding.ItemPlaymarketKidsGamesAppsForuAppsBinding
import com.common.codeschoolandroidlessons.databinding.ItemPlaymarketTopChartsGamesAppsBinding
import com.cshomework.codeschoolandroidlessons.playmarket.data.apps_model.*
import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.cshomework.codeschoolandroidlessons.playmarket.data.games_model.*
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.OnItemClickListener

class BaseAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    private val items: MutableList<BaseItemType> = mutableListOf()

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
            VIEW_TYPE_TOP_CHARTS -> TopChartsItemViewHolder(
                ItemPlaymarketTopChartsGamesAppsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            VIEW_TYPE_GAMES_FOR_YOU -> GamesForYouItemViewHolder(
                ItemPlaymarketForYouGamesBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            VIEW_TYPE_CATEGORIES -> CategoriesItemViewHolder(
                ItemPlaymarketCategoriesGamesAppsBinding.inflate(layoutInflater, parent, false)
            )
            VIEW_TYPE_KIDS_AND_FOR_YOU_APPS -> KidsAndAppsForYouItemViewHolder(
                ItemPlaymarketKidsGamesAppsForuAppsBinding.inflate(layoutInflater, parent, false)
            )
            VIEW_TYPE_TOP_CHARTS_TOP_FREE -> TopChartsTopFreeItemViewHolder(
                ItemPlaymarketCategoriesGamesAppsBinding.inflate(layoutInflater, parent, false)
            )
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
            is AppsKidsDto, is GamesKidsDto, is AppsForYouDto -> VIEW_TYPE_KIDS_AND_FOR_YOU_APPS
            is GamesTopChartsTopFreeDto, is AppsTopChartsTopFreeDto -> VIEW_TYPE_TOP_CHARTS_TOP_FREE
            else -> UNDEFINED
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<BaseItemType>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                if (absoluteAdapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
                onItemClickListener.onItemClicked(items[absoluteAdapterPosition])
            }
        }
        abstract fun bind(item: BaseItemType)
    }

    private inner class GamesForYouItemViewHolder(val binding: ItemPlaymarketForYouGamesBinding) : BaseViewHolder(binding.root) {

        override fun bind(item: BaseItemType) {
            when (item) {
                is GameForYouDto -> {
                    binding.nameTextView.text = item.title
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.mainForYouImageView)
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.secondaryForYouImageView)
                    binding.ratingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.text = item.memory.toString()
                }
            }
        }
    }
    private inner class TopChartsItemViewHolder(val binding: ItemPlaymarketTopChartsGamesAppsBinding) : BaseViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        override fun bind(item: BaseItemType) {
            when (item) {
                is GameTopChartsDto -> {
                    binding.topChartsTitleTextView.text = item.title
                    binding.topChartsNumberTextView.text = (absoluteAdapterPosition + 1).toString()
                    binding.topChartsRatingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.text = item.memory.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.topChartsImageView)
                }
                is AppsTopChartsDto -> {
                    binding.topChartsTitleTextView.text = item.title
                    binding.topChartsNumberTextView.text = (absoluteAdapterPosition + 1).toString()
                    binding.topChartsRatingTextView.text = item.rating.toString()
                    binding.topChartsMemorySizeTextView.isVisible = false
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.topChartsImageView)
                }
            }
        }
    }
    private inner class CategoriesItemViewHolder(val binding: ItemPlaymarketCategoriesGamesAppsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: BaseItemType) {
            when (item) {
                is GamesCategoryDto -> {
                    binding.categoriesTextView.text = item.title
                }
                is AppsCategoriesDto -> {
                    binding.categoriesTextView.text = item.title
                }
            }
        }
    }
    private inner class TopChartsTopFreeItemViewHolder(val binding: ItemPlaymarketCategoriesGamesAppsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: BaseItemType) {
            when (item) {
                is GamesTopChartsTopFreeDto -> {
                    binding.categoriesTextView.text = item.title
                }
                is AppsTopChartsTopFreeDto -> {
                    binding.categoriesTextView.text = item.title
                }
            }
        }
    }
    private inner class KidsAndAppsForYouItemViewHolder(val binding: ItemPlaymarketKidsGamesAppsForuAppsBinding) : BaseViewHolder(binding.root) {

        override fun bind(item: BaseItemType) {
            when (item) {
                is GamesKidsDto -> {
                    binding.kidsForUNameTextView.text = item.title
                    binding.kidsForURatingTextView.text = item.rating.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.kidsForUImageView)
                }
                is AppsKidsDto -> {
                    binding.kidsForUNameTextView.text = item.title
                    binding.kidsForURatingTextView.text = item.rating.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.kidsForUImageView)
                }
                is AppsForYouDto -> {
                    binding.kidsForUNameTextView.text = item.title
                    binding.kidsForURatingTextView.text = item.rating.toString()
                    Glide.with(context).load(item.imageUrl).centerCrop().into(binding.kidsForUImageView)
                }
            }
        }
    }

    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TOP_CHARTS = 1
        private const val VIEW_TYPE_GAMES_FOR_YOU = 2
        private const val VIEW_TYPE_CATEGORIES = 3
        private const val VIEW_TYPE_KIDS_AND_FOR_YOU_APPS = 4
        private const val VIEW_TYPE_TOP_CHARTS_TOP_FREE = 5

    }
}