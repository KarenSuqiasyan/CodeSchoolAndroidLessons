package com.example.codeschoolandroidlessons.playmarket.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.codeschoolandroidlessons.databinding.ItemScrollableRecyclerviewForuKidsBinding
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsForYouDto
import com.example.codeschoolandroidlessons.playmarket.data.apps_model.AppsKidsDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GameForYouDto
import com.example.codeschoolandroidlessons.playmarket.data.games_model.GamesKidsDto

class GlobalScrollAdapter : RecyclerView.Adapter<GlobalScrollAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    private val items = mutableListOf<List<Any>>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = PlayStoreMainViewHolder(ItemScrollableRecyclerviewForuKidsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: List<Any>)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<List<Any>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private inner class PlayStoreMainViewHolder(val binding: ItemScrollableRecyclerviewForuKidsBinding) : BaseViewHolder(binding.root) {

        val adapter = MainAdapter()

        init {
            binding.scrollableForUAndKidsRecyclerView.adapter = adapter
        }

        override fun bind(item: List<Any>) {
            binding.titleTextview.text = when (item[absoluteAdapterPosition]) {
                is GameForYouDto -> "Games For You"
                is AppsForYouDto -> "Apps For You"
                is GamesKidsDto -> "Games For Kids"
                is AppsKidsDto -> "Games For Kids"
                else -> "Other Programs"
            }
            adapter.updateData(item)
        }
    }
}