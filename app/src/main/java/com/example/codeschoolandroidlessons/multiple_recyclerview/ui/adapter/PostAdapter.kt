package com.example.codeschoolandroidlessons.multiple_recyclerview.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codeschoolandroidlessons.databinding.ItemImageBinding
import com.example.codeschoolandroidlessons.databinding.ItemTextBinding
import com.example.codeschoolandroidlessons.databinding.ItemUrlBinding
import com.example.codeschoolandroidlessons.databinding.ItemVideoBinding
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.ImagePost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.TextPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.UrlPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.VideoPost

class PostAdapter(private val postItemClickListener: (PostActionEnum, Any) -> Unit) : RecyclerView.Adapter<PostAdapter.BaseViewHolder>() {

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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])

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
        init {
            binding.root.setOnClickListener {
                binding.showTextview.isVisible = true
                binding.itemTextView.text = (items[absoluteAdapterPosition] as TextPost).text.substring(0, 100)
            }
            binding.showTextview.setOnClickListener {
                binding.showTextview.isVisible = false
                binding.itemTextView.text = (items[absoluteAdapterPosition] as TextPost).text
            }
            binding.textPostIncludedLayout.shareButton.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_SHARE_TEXT, items[absoluteAdapterPosition]) }
        }

        override fun bind(item: Any) {
            binding.showTextview.isVisible = true
            (item as TextPost).let {
                val text = item.text.substring(0, 100)
                binding.itemTextView.text = text
            }
        }
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) : BaseViewHolder(binding.root) {
        init {
            binding.videoPostIncludedLayout.shareButton.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_SHARE_VIDEO, items[absoluteAdapterPosition]) }
        }

        override fun bind(item: Any) {
            (item as VideoPost).let {
                binding.itemVideo.setVideoURI(Uri.parse(it.videoUrl))
                binding.itemVideo.setMediaController(MediaController(context))
                binding.itemVideo.start()
            }
        }
    }

    inner class UrlViewHolder(private val binding: ItemUrlBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_URL_ITEM_CLICK, items[absoluteAdapterPosition]) }
            binding.urlPostIncludedLayout.shareButton.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_SHARE_URL, items[absoluteAdapterPosition]) }
        }

        override fun bind(item: Any) {
            (item as UrlPost).let {
                binding.urlTextView.text = item.url
                Glide.with(context).load(item.imageUrl).into(binding.urlImageView)
            }
        }
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_IMAGE_ITEM_CLICK, items[absoluteAdapterPosition]) }
            binding.imagePostIncludedLayout.shareButton.setOnClickListener { postItemClickListener(PostActionEnum.ACTION_SHARE_IMAGE, items[absoluteAdapterPosition]) }
        }

        override fun bind(item: Any) {
            (item as ImagePost).let {
                Glide.with(context).load(item.imageUrl).into(binding.itemImageview)
            }
        }
    }

    enum class PostActionEnum {
        ACTION_URL_ITEM_CLICK,
        ACTION_IMAGE_ITEM_CLICK,
        ACTION_SHARE_IMAGE,
        ACTION_SHARE_TEXT,
        ACTION_SHARE_URL,
        ACTION_SHARE_VIDEO

    }

    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TEXT_POST = 1
        private const val VIEW_TYPE_URL_POST = 2
        private const val VIEW_TYPE_VIDEO_POST = 3
        private const val VIEW_TYPE_IMAGE_POST = 4

        const val URL_FOR_WEB_VIEW = "url for web view"
        const val FULL_SCREEN_IMAGE = "full screen image"
    }
}