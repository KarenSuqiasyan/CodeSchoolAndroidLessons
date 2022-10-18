package com.example.codeschoolandroidlessons.multiple_recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.*
import com.example.codeschoolandroidlessons.recyclerview_countries.data.model.CountriesEnum
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter

class PostAdapter(private val items: MutableList<Any> = mutableListOf(), private val postItemClickListener: (PostAdapter.PostActionEnum, Any) -> Unit) : RecyclerView.Adapter<PostAdapter.BaseViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

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

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is TextPost -> VIEW_TYPE_TEXT_POST
            is VideoPost -> VIEW_TYPE_VIDEO_POST
            is ImagePost -> VIEW_TYPE_IMAGE_POST
            is UrlPost -> VIEW_TYPE_URL_POST
            else -> UNDEFINED
        }
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

    inner class TextViewHolder(private val binding: ItemTextBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as TextPost).let {
                binding.itemTextView.text = item.text
            }
        }
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as VideoPost).let {
                binding.itemVideo.setVideoURI(Uri.parse(it.videoUrl))
                binding.itemVideo.setMediaController(MediaController(context))
                binding.itemVideo.start()
            }
        }
    }

    inner class UrlViewHolder(private val binding: ItemUrlBinding) : BaseViewHolder(binding.root) {

        private lateinit var webViewBinding: ActivityWebViewBinding
        override fun bind(item: Any) {
            (item as UrlPost).let {
                binding.urlTextView.text = item.url

            }
        }
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any) {
            (item as ImagePost).let {
                Glide.with(context).load(item.imageUrl).into(binding.itemImageview)
            }
        }
    }

    enum class PostActionEnum {
        ACTION_ITEM_CLICK,
        ACTION_IMAGE_CLICK,
    }

    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TEXT_POST = 1
        private const val VIEW_TYPE_URL_POST = 2
        private const val VIEW_TYPE_VIDEO_POST = 3
        private const val VIEW_TYPE_IMAGE_POST = 4
    }
}