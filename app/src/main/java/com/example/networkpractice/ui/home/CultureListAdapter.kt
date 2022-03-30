package com.example.networkpractice.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.networkpractice.databinding.RvItemCultureBinding
import com.example.networkpractice.network.model.CultureModel

class CultureListAdapter:
    PagingDataAdapter<CultureModel, CultureListAdapter.CultureViewHolder>(
        object : DiffUtil.ItemCallback<CultureModel>() {
            override fun areItemsTheSame(oldItem: CultureModel, newItem: CultureModel): Boolean {
                return oldItem.seq == newItem.seq
            }

            override fun areContentsTheSame(oldItem: CultureModel, newItem: CultureModel): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    interface OnItemClickListener {
        fun onItemClicked(item: CultureModel?)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener

    override fun onBindViewHolder(holder: CultureListAdapter.CultureViewHolder, position: Int) {
        val item = getItem(position)?: return
        holder.onBind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CultureListAdapter.CultureViewHolder {
        return CultureViewHolder(binding = RvItemCultureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class CultureViewHolder(private val binding: RvItemCultureBinding):
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener.onItemClicked(binding.item)
            }
        }

        fun onBind(item: CultureModel) {
            binding.item = item
        }
    }
}