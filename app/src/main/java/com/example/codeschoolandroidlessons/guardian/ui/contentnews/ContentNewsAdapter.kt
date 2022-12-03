//package com.example.codeschoolandroidlessons.guardian.ui.contentnews
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.codeschoolandroidlessons.databinding.ItemGuardianContentNewsBinding
//import com.example.codeschoolandroidlessons.guardian.data.model.Result
//
//class ContentNewsAdapter : RecyclerView.Adapter<ContentNewsAdapter.BaseViewHolder>() {
//
//    private val items: MutableList<Result> = mutableListOf()
//
//    private lateinit var context: Context
//    private lateinit var layoutInflater: LayoutInflater
//
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        context = recyclerView.context
//        layoutInflater = LayoutInflater.from(context)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(ItemGuardianContentNewsBinding.inflate(layoutInflater, parent, false))
//
//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(items[position])
//
//    override fun getItemCount() = items.size
//
//    private var onItemClickListener: ((Result) -> Unit)? = null
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun updateData(items: List<Result>) {
//        this.items.clear()
//        this.items.addAll(items)
//        notifyDataSetChanged()
//    }
//
//    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        abstract fun bind(item: Result)
//    }
//
//    inner class NewsViewHolder(private val binding: ItemGuardianContentNewsBinding) : BaseViewHolder(binding.root) {
//        override fun bind(item: Result) {
//            binding.titleTextView.text = item.sectionName
//            binding.descriptionTextView.text = item.webTitle
//            binding.publicationDateTextView.text = item.webPublicationDate
//            item.fields.thumbnail.let { Glide.with(context).load(item.fields.thumbnail).centerCrop().into(binding.contentImageView) }
//            itemView.setOnClickListener {
//                onItemClickListener?.let { it(item) }
//            }
//        }
//    }
//
//    fun setOnItemClickListener(listener: (Result) -> Unit) {
//        onItemClickListener = listener
//    }
//}