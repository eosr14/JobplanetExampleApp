package com.eosr14.jobplanetexampleapp.ui.main.viewHolder

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemJobPostingBinding
import com.eosr14.jobplanetexampleapp.model.Search

class MainListJobPostingViewHolder(private val binding: ItemJobPostingBinding) :
    BaseViewHolder<Search.Items>(binding.root) {
    override fun bind(item: Search.Items) {
        binding.item = item
    }
}