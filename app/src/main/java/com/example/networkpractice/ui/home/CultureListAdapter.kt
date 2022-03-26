package com.example.networkpractice.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.networkpractice.databinding.RvItemCultureBinding
import com.example.networkpractice.network.model.CultureModel

class CultureListAdapter:
    PagingDataAdapter<CultureModel, CultureListAdapter.ImageViewHolder>(
        object : DiffUtil.ItemCallback<CultureModel>() {
            override fun areItemsTheSame(oldItem: CultureModel, newItem: CultureModel): Boolean {
                Log.d("tag_diff", "diff확인중")
                return oldItem.seq == newItem.seq
            }

            override fun areContentsTheSame(oldItem: CultureModel, newItem: CultureModel): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    override fun onBindViewHolder(holder: CultureListAdapter.ImageViewHolder, position: Int) {
        val item = getItem(position)?: return
        holder.onBind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CultureListAdapter.ImageViewHolder {
        return ImageViewHolder(binding = RvItemCultureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ImageViewHolder(private val binding: RvItemCultureBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CultureModel) {
            binding.item = item
        }
    }
}