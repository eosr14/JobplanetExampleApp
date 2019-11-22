package com.eosr14.jobplanetexampleapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.common.base.BaseRecyclerViewAdapter
import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.model.Search
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.MainHorizontalThemeItemViewHolder

class MainHorizontalThemeAdapter(
    themes : MutableList<Search.Theme>,
    onItemClickListener: OnItemClickListener
) :
    BaseRecyclerViewAdapter<Search.Theme, BaseViewHolder<Search.Theme>>() {

    init {
        this.onItemClickListener = onItemClickListener
        setItems(themes)
    }

    override fun onBindView(holder: BaseViewHolder<Search.Theme>, position: Int) {
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
