package com.example.customviewitems.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewitems.data.ItemModel2
import com.example.customviewitems.databinding.RecyclerItemBinding

class RecyclerAdapter :
    androidx.recyclerview.widget.ListAdapter<ItemModel2, RecyclerAdapter.ItemViewHolder>(ItemCallback) {

    var onItemClickListener: ((ItemModel2) -> Unit)? = null

    inner class ItemViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = item.title
                tvSubtitle.text = item.subTitle
                ivImage.setImageResource(item.image)
                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<ItemModel2>() {
        override fun areItemsTheSame(
            oldItem: ItemModel2,
            newItem: ItemModel2,
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: ItemModel2,
            newItem: ItemModel2,
        ): Boolean {
            return oldItem == newItem
        }
    }
}
