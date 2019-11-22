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
import com.eosr14.jobplanetexampleapp.common.construct
import com.eosr14.jobplanetexampleapp.model.ItemType
import com.eosr14.jobplanetexampleapp.model.Search
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.MainListHorizontalThemeHolder
import kotlinx.android.synthetic.main.item_horizontal_theme.view.*
import kotlin.reflect.full.primaryConstructor

class MainListAdapter(onItemClickListener: OnItemClickListener) :
    BaseRecyclerViewAdapter<Search.Items, BaseViewHolder<Search.Items>>() {


    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).companyItemType.ordinal
    }

    override fun onBindView(holder: BaseViewHolder<Search.Items>, position: Int) {
        when (holder) {
            is MainListHorizontalThemeHolder -> {
                holder.itemView.recyclerview_horizontal_theme.run {
                    addItemDecoration(HorizontalMarginDecoration(context))
                    layoutManager =
                        LinearLayoutManager(context).apply { orientation = RecyclerView.HORIZONTAL }
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


    @Suppress("UNCHECKED_CAST")
    private fun createViewHolder(holderName : Class<*>, binding : ViewDataBinding) : BaseViewHolder<Search.Items> {
        return construct(holderName.kotlin, binding) as BaseViewHolder<Search.Items>
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    private fun newViewHolderInstance(holderName : Class<*>, view: ViewDataBinding): RecyclerView.ViewHolder {
        return holderName.kotlin.primaryConstructor?.call(view) as RecyclerView.ViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        ItemType.Type.values()[viewType].run {
            return newViewHolderInstance(
                this.holderName,
                DataBindingUtil.inflate<ViewDataBinding>(
                    LayoutInflater.from(parent.context), this.layoutId, parent, false
                )
            )
        }

//        return when (viewType) {
//            CompanyItemType.COMPANY.ordinal -> MainListCompanyViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_company,
//                    parent,
//                    false
//                )
//            )
//            CompanyItemType.JOB_POSTING.ordinal -> MainListJobPostingViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_job_posting,
//                    parent,
//                    false
//                )
//            )
//            CompanyItemType.REVIEW.ordinal -> MainListReViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_review,
//                    parent,
//                    false
//                )
//            )
//            CompanyItemType.INTERVIEW.ordinal -> MainListInterViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_interview,
//                    parent,
//                    false
//                )
//            )
//            CompanyItemType.SALARY.ordinal -> MainListSalaryViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_salary,
//                    parent,
//                    false
//                )
//            )
//            CompanyItemType.HORIZONTAL_THEME.ordinal -> MainListHorizontalThemeHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_horizontal_theme,
//                    parent,
//                    false
//                )
//            )
//            else -> MainListEmptyViewHolder(
//                DataBindingUtil.inflate(
//                    LayoutInflater.from(parent.context),
//                    R.layout.item_empty,
//                    parent,
//                    false
//                )
//            )
//        }
    }
}
