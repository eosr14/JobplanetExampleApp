package com.eosr14.jobplanetexampleapp.ui.main

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemHorizontalThemeBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListHorizontalThemeHolder(private val binding: ItemHorizontalThemeBinding) :
    BaseViewHolder<CompanySearch.Items>(binding.root) {
    override fun bind(item: CompanySearch.Items) {
        binding.item = item
    }
}