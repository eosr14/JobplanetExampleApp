package com.eosr14.jobplanetexampleapp.ui.main

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemInterviewBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListInterViewHolder(private val binding: ItemInterviewBinding) :
    BaseViewHolder<CompanySearch.Items>(binding.root) {
    override fun bind(item: CompanySearch.Items) {
        binding.item = item
    }
}