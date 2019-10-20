package com.eosr14.jobplanetexampleapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.common.base.BaseRecyclerViewAdapter
import com.eosr14.jobplanetexampleapp.common.base.BaseViewHolder
import com.eosr14.jobplanetexampleapp.model.CompanySearch

class MainListAdapter(onItemClickListener: OnItemClickListener) :
    BaseRecyclerViewAdapter<CompanySearch.Items, BaseViewHolder<CompanySearch.Items>>() {

//    CELL_TYPE_COMPANY : 메인 / 기업정보 더보기
//    CELL_TYPE_HORIZONTAL_THEME : 메인 / 가로 스크롤 정보
//    CELL_TYPE_JOB_POSTING : 메인 / 채용정보
//    CELL_TYPE_INTERVIEW : 메인 / 면접후기
//    CELL_TYPE_SALARY : 메인 / 연봉정보
//    CELL_TYPE_REVIEW : 메인 / 기업리뷰 더 보기

    private enum class CompanyItemType(val value: String) {
        COMPANY("CELL_TYPE_COMPANY"),
        HORIZONTAL_THEME("CELL_TYPE_HORIZONTAL_THEME"),
        JOB_POSTING("CELL_TYPE_JOB_POSTING"),
        INTERVIEW("CELL_TYPE_INTERVIEW"),
        SALARY("CELL_TYPE_SALARY"),
        REVIEW("CELL_TYPE_REVIEW"),
        EMPTY("EMPTY_TEST")
    }

    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).cellType) {
            CompanyItemType.COMPANY.value -> CompanyItemType.COMPANY.ordinal
            CompanyItemType.JOB_POSTING.value -> CompanyItemType.JOB_POSTING.ordinal
            CompanyItemType.REVIEW.value -> CompanyItemType.REVIEW.ordinal
            CompanyItemType.INTERVIEW.value -> CompanyItemType.INTERVIEW.ordinal
            else -> CompanyItemType.EMPTY.ordinal
        }
    }


    override fun onBindView(holder: BaseViewHolder<CompanySearch.Items>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            CompanyItemType.COMPANY.ordinal -> MainListCompanyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_company, parent, false))
            CompanyItemType.JOB_POSTING.ordinal -> MainListJobPostingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_job_posting, parent, false))
            CompanyItemType.REVIEW.ordinal -> MainListReViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_review, parent, false))
            CompanyItemType.INTERVIEW.ordinal -> MainListInterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_interview, parent, false))
            else -> MainListEmptyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_empty, parent, false))
        }
    }
}
