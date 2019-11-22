package com.eosr14.jobplanetexampleapp.ui.main.viewHolder

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemHorizontalThemeSubBinding
import com.eosr14.jobplanetexampleapp.model.Search

class MainHorizontalThemeItemViewHolder(private val binding: ItemHorizontalThemeSubBinding) :
    BaseViewHolder<Search.Theme>(binding.root) {
    override fun bind(theme: Search.Theme) {
        binding.theme = theme
    }
}