package com.example.codeschoolandroidlessons.multiple_recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.BaseViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

    private val items: MutableList<Any> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_TEXT_POST -> TextViewHolder(ItemTextBinding.inflate(layoutInflater, parent, false))
        VIEW_TYPE_VIDEO_POST -> VideoViewHolder(ItemVideoBinding.inflate(layoutInflater, parent, false))
        VIEW_TYPE_IMAGE_POST -> ImageViewHolder(ItemImageBinding.inflate(layoutInflater, parent, false))
        VIEW_TYPE_URL_POST -> UrlViewHolder(ItemUrlBinding.inflate(layoutInflater, parent, false))
        else -> throw IllegalArgumentException("undefined viewType: $viewType in ${this::class.java.simpleName}")
    }

    override fun onBindViewHolder(holder: PostAdapter.BaseViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int) = when (val currentItem = items[position]) {
            (currentItem is TextPost) -> VIEW_TYPE_TEXT_POST
            (currentItem is VideoPost) -> VIEW_TYPE_VIDEO_POST
            (currentItem is ImagePost) -> VIEW_TYPE_IMAGE_POST
            (currentItem is UrlPost) -> VIEW_TYPE_URL_POST
            else -> UNDEFINED
        }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: MutableList<Any>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: Any)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class TextViewHolder(private val binding: ItemTextBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as TextPost).let {
                binding.itemTextView.text = item.text
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class VideoViewHolder(private val binding: ItemVideoBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as VideoPost).let {
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class UrlViewHolder(private val binding: ItemUrlBinding) : BaseViewHolder(binding.root) {

        private lateinit var webViewBinding: ActivityWebViewBinding
        override fun bind(item: Any) {
            (item as UrlPost).let {
                binding.urlTextView.text = item.url
                val myWebView: WebView = webViewBinding.webView
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ImageViewHolder(private val binding: ItemImageBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as ImagePost).let {
                Glide.with(context).load(item.imageUrl).into(binding.itemImageview)
            }
        }
    }

    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TEXT_POST = 1
        private const val VIEW_TYPE_URL_POST = 2
        private const val VIEW_TYPE_VIDEO_POST = 3
        private const val VIEW_TYPE_IMAGE_POST = 4
    }

}