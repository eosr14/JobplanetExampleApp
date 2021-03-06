package com.eosr14.jobplanetexampleapp.ui.main

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemEmptyBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListEmptyViewHolder(private val binding: ItemEmptyBinding) :
    BaseViewHolder<CompanySearch.Items>(binding.root) {
    override fun bind(item: CompanySearch.Items) {
        binding.item = item
    }
}