package com.eosr14.jobplanetexampleapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.common.HorizontalMarginDecoration
import com.eosr14.jobplanetexampleapp.common.base.BaseRecyclerViewAdapter
import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.model.ItemType
import com.eosr14.jobplanetexampleapp.model.Search
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.MainListHorizontalThemeHolder
import kotlinx.android.synthetic.main.item_horizontal_theme.view.*

class MainListAdapter(onItemClickListener: OnItemClickListener) :
    BaseRecyclerViewAdapter<Search.Items, BaseViewHolder<Search.Items>>() {


    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemType.ordinal
    }

    override fun onBindView(holder: BaseViewHolder<Search.Items>, position: Int) {
        when (holder) {
            is MainListHorizontalThemeHolder -> {
                holder.itemView.recyclerview_horizontal_theme.run {
                    addItemDecoration(HorizontalMarginDecoration(context))
                    layoutManager = LinearLayoutManager(context).apply { orientation = RecyclerView.HORIZONTAL }
                    adapter = MainHorizontalThemeAdapter(
                        getItem(position).themes,
                        object : OnItemClickListener {
                            override fun onItemClick(
                                view: View,
                                position: Int,
                                adapter: BaseRecyclerViewAdapter<*, *>
                            ) {
                                // TODO : 상세 페이지로 이동
                            }
                        })
                }
            }
            else -> holder.bind(getItem(position))
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val type = ItemType.Type.values()[viewType]
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            type.layoutId,
            parent,
            false
        )

        return ItemType.newViewHolderInstance(type.holderClass, binding)
    }
}
