package com.eosr14.jobplanetexampleapp.ui.main.viewHolder

import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.databinding.ItemSalaryBinding
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListSalaryViewHolder(private val binding: ItemSalaryBinding) :
    BaseViewHolder<CompanySearch.Items>(binding.root) {
    override fun bind(item: CompanySearch.Items) {
        binding.item = item
    }
}