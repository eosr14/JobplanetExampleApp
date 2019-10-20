package com.eosr14.jobplanetexampleapp.ui.main

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemCompanyBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListCompanyViewHolder(private val binding: ItemCompanyBinding) :
    BaseViewHolder<CompanySearch.Items>(binding.root) {
    override fun bind(item: CompanySearch.Items) {
        binding.item = item
    }
}