package com.eosr14.jobplanetexampleapp.model

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.*
import kotlin.reflect.full.primaryConstructor

object ItemType {

    //    CELL_TYPE_COMPANY : 메인 / 기업정보 더보기
    //    CELL_TYPE_HORIZONTAL_THEME : 메인 / 가로 스크롤 정보
    //    CELL_TYPE_JOB_POSTING : 메인 / 채용정보
    //    CELL_TYPE_INTERVIEW : 메인 / 면접후기
    //    CELL_TYPE_SALARY : 메인 / 연봉정보
    //    CELL_TYPE_REVIEW : 메인 / 기업리뷰 더 보기

    enum class Type(val layoutId: Int, val holderClass: Class<*>) {
        CELL_TYPE_COMPANY(R.layout.item_company, MainListCompanyViewHolder::class.java),
        CELL_TYPE_HORIZONTAL_THEME(R.layout.item_horizontal_theme, MainListHorizontalThemeHolder::class.java),
        CELL_TYPE_JOB_POSTING(R.layout.item_job_posting, MainListJobPostingViewHolder::class.java),
        CELL_TYPE_INTERVIEW(R.layout.item_interview, MainListInterViewHolder::class.java),
        CELL_TYPE_SALARY(R.layout.item_salary, MainListSalaryViewHolder::class.java),
        CELL_TYPE_REVIEW(R.layout.item_review, MainListReViewHolder::class.java),
        EMPTY(R.layout.item_empty, MainListEmptyViewHolder::class.java)
    }

    fun newViewHolderInstance(holderName : Class<*>, binding: ViewDataBinding): RecyclerView.ViewHolder {
        return holderName.kotlin.primaryConstructor?.call(binding) as RecyclerView.ViewHolder
    }

}