package com.eosr14.jobplanetexampleapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.common.base.BaseRecyclerViewAdapter
import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.model.CompanySearch
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.MainHorizontalThemeItemViewHolder

class MainHorizontalThemeAdapter(
    themes : MutableList<CompanySearch.Theme>,
    onItemClickListener: OnItemClickListener
) :
    BaseRecyclerViewAdapter<CompanySearch.Theme, BaseViewHolder<CompanySearch.Theme>>() {

    init {
        this.onItemClickListener = onItemClickListener
        setItems(themes)
    }

    override fun onBindView(holder: BaseViewHolder<CompanySearch.Theme>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainHorizontalThemeItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_horizontal_theme_sub,
                parent,
                false
            )
        )
    }
}
