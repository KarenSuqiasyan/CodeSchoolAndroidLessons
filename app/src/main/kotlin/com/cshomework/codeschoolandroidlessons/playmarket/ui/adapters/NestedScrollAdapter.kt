package com.cshomework.codeschoolandroidlessons.playmarket.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.common.codeschoolandroidlessons.databinding.ItemPlaymarketScrollableRecyclerviewForuKidsBinding
import com.cshomework.codeschoolandroidlessons.playmarket.data.apps_model.AppsForYouDto
import com.cshomework.codeschoolandroidlessons.playmarket.data.apps_model.AppsKidsDto
import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.cshomework.codeschoolandroidlessons.playmarket.data.games_model.GameForYouDto
import com.cshomework.codeschoolandroidlessons.playmarket.data.games_model.GamesKidsDto
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.OnItemClickListener

class NestedScrollAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<NestedScrollAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    private val items = mutableListOf<List<BaseItemType>>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        PlayStoreMainViewHolder(ItemPlaymarketScrollableRecyclerviewForuKidsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: List<BaseItemType>)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<List<BaseItemType>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private inner class PlayStoreMainViewHolder(val binding: ItemPlaymarketScrollableRecyclerviewForuKidsBinding) : BaseViewHolder(binding.root) {

        val adapter = BaseAdapter(onItemClickListener)

        init {
            binding.scrollableForUAndKidsRecyclerView.adapter = adapter
        }

        override fun bind(item: List<BaseItemType>) {
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