package com.eosr14.jobplanetexampleapp.model


import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.ui.main.viewHolder.*

object ItemType {

    //    CELL_TYPE_COMPANY : 메인 / 기업정보 더보기
    //    CELL_TYPE_HORIZONTAL_THEME : 메인 / 가로 스크롤 정보
    //    CELL_TYPE_JOB_POSTING : 메인 / 채용정보
    //    CELL_TYPE_INTERVIEW : 메인 / 면접후기
    //    CELL_TYPE_SALARY : 메인 / 연봉정보
    //    CELL_TYPE_REVIEW : 메인 / 기업리뷰 더 보기

    enum class Type(val cellType: String, val layoutId: Int, val holderName: Class<*>) {
        COMPANY("CELL_TYPE_COMPANY", R.layout.item_company, MainListCompanyViewHolder::class.java),
        HORIZONTAL_THEME("CELL_TYPE_HORIZONTAL_THEME", R.layout.item_horizontal_theme, MainHorizontalThemeItemViewHolder::class.java),
        JOB_POSTING("CELL_TYPE_JOB_POSTING", R.layout.item_job_posting, MainListJobPostingViewHolder::class.java),
        INTERVIEW("CELL_TYPE_INTERVIEW", R.layout.item_interview, MainListInterViewHolder::class.java),
        SALARY("CELL_TYPE_SALARY", R.layout.item_salary, MainListSalaryViewHolder::class.java),
        REVIEW("CELL_TYPE_REVIEW", R.layout.item_review, MainListReViewHolder::class.java),
        EMPTY("CELL_TYPE_EMPTY", R.layout.item_empty, MainListEmptyViewHolder::class.java)
    }


}