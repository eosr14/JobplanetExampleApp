package com.eosr14.jobplanetexampleapp.ui.main.viewHolder

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemHorizontalThemeSubBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainHorizontalThemeItemViewHolder(private val binding: ItemHorizontalThemeSubBinding) :
    BaseViewHolder<CompanySearch.Theme>(binding.root) {
    override fun bind(theme: CompanySearch.Theme) {
        binding.theme = theme
    }
}