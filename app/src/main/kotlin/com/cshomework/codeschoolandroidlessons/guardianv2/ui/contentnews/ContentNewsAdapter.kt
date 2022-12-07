package com.cshomework.codeschoolandroidlessons.guardianv2.ui.contentnews

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.common.codeschoolandroidlessons.databinding.ItemGuardianContentNewsBinding
import com.common.guardian.news.data.NewsResultDto

class ContentNewsAdapter(private val onItemClick: (NewsResultDto) -> Unit) : RecyclerView.Adapter<ContentNewsAdapter.BaseViewHolder>() {

    private val items: MutableList<NewsResultDto?> = mutableListOf()

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(ItemGuardianContentNewsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    private var onItemClickListener: ((NewsResultDto) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<NewsResultDto?>?) {
        items?.let {
            this.items.clear()
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: NewsResultDto?)
    }

    inner class NewsViewHolder(private val binding: ItemGuardianContentNewsBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: NewsResultDto?) {
            binding.titleTextView.text = item?.sectionName
            binding.descriptionTextView.text = item?.webTitle
            binding.publicationDateTextView.text = item?.webPublicationDate
            item?.fields?.thumbnail.let {
                Glide.with(context).load(item?.fields?.thumbnail).centerCrop()
                    .into(binding.contentImageView)
            }
            itemView.setOnClickListener {
                if (item != null) {
                    onItemClick.invoke(item)
                }
            }
        }
    }
}