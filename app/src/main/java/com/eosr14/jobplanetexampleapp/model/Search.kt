package com.eosr14.jobplanetexampleapp.model

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("minimum_interviews")
    val minimumInterviews: Int = 0,

    @SerializedName("total_page")
    val totalPage: Int = 0,

    @SerializedName("minimum_reviews")
    val minimumReviews: Int = 0,

    @SerializedName("total_count")
    val totalCount: Int = 0,

    @SerializedName("items")
    val items: List<Items> = mutableListOf(),

    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("page_size")
    val pageSize: Int = 0,

    @SerializedName("minimum_salaries")
    val minimumSalaries: Int = 0
) {
    data class Items (

        var itemType : ItemType.Type = ItemType.Type.EMPTY,
        var childList : List<Any> = mutableListOf(),

        @SerializedName("cell_type")
        val cellType: String = "",

        @SerializedName("ranking")
        val ranking: String = "",

        @SerializedName("company_id")
        val companyId: Int = 0,

        @SerializedName("interview_question")
        val interviewQuestion: String = "",

        @SerializedName("interview_difficulty")
        val interviewDifficulty: Double = 0.0,

        @SerializedName("name")
        val name: String = "",

        @SerializedName("rate_total_avg")
        val rateTotalAvg: Double = 0.0,

        @SerializedName("industry_id")
        val industryId: Int = 0,

        @SerializedName("type")
        val type: String = "",

        @SerializedName("industry_name")
        val industryName: String = "",

        @SerializedName("simple_desc")
        val simpleDesc: String = "",

        // CELL_TYPE_COMPANY [--
        @SerializedName("salary_avg")
        val salaryAvg: Int = 0,

        @SerializedName("web_site")
        val webSite: String = "",

        @SerializedName("logo_path")
        val logoPath: String = "",

        @SerializedName("has_job_posting")
        val hasJobPosting: String = "",

        @SerializedName("review_summary")
        val reviewSummary: String = "",
        // --] CELL_TYPE_COMPANY

        // [-- CELL_TYPE_HORIZONTAL_THEME
        @SerializedName("count")
        val count: Int = 0,

        @SerializedName("themes")
        val themes: MutableList<Theme> = mutableListOf(),
        // --] CELL_TYPE_HORIZONTAL_THEME

        // [-- CELL_TYPE_JOB_POSTING
        @SerializedName("occupation_ids")
        val occupationIds: List<Int> = mutableListOf(),

        @SerializedName("is_interview")
        val isInterview: String = "",

        @SerializedName("job_type_ids")
        val jobTypeIds: List<Int> = mutableListOf(),

        @SerializedName("city_ids")
        val cityIds: List<Int> = mutableListOf(),

        @SerializedName("deadline")
        val deadLine: DeadLine = DeadLine(),

        @SerializedName("recruitment_type_ids")
        val recruitmentTypeIds: List<Int> = mutableListOf(),

        @SerializedName("logo")
        val logo: String = "",

        @SerializedName("id")
        val id: Int = 0,

        @SerializedName("review_avg_cache")
        val reviewAvgCache: Double = 0.0,

        @SerializedName("title")
        val title: String = "",

        @SerializedName("label_id")
        val labelId: String = "",

        @SerializedName("is_saved")
        val isSaved: String = "",

        @SerializedName("company_name")
        val companyName: String = "",
        // --] CELL_TYPE_JOB_POSTING

        // [-- CELL_TYPE_INTERVIEW
        @SerializedName("interview_range_end")
        val interviewRangeEnd: Double = 0.0,

        @SerializedName("interview_answer")
        val interviewAnswer: String = "",

        @SerializedName("interview_summary")
        val interviewSummary: String = "",

        @SerializedName("interview_desc")
        val interviewDesc: String = "",

        @SerializedName("interview_range_start")
        val interviewRangeStart: Double = 0.0,
        // --] CELL_TYPE_INTERVIEW

        // [-- CELL_TYPE_SALARY
        @SerializedName("salary_ranking")
        val salaryRanking: String = "",

        @SerializedName("hide_detail")
        val hideDetail: Int = 0,

        @SerializedName("signed_in")
        val signed_in: Int = 0,

        @SerializedName("salary_lowest")
        val salaryLowest: Int = 0,

        @SerializedName("salary_highest")
        val salaryHighest: Int = 0,
        // --] CELL_TYPE_SALARY

        // [-- CELL_TYPE_REVIEW
        @SerializedName("cons")
        val cons: String = "",

        @SerializedName("days_ago")
        val daysAgo: String = "",

        @SerializedName("pros")
        val pros: String = "",

        @SerializedName("occupation_name")
        val occupationName: String = "",

        @SerializedName("date")
        val date: String = ""
        // --] CELL_TYPE_REVIEW
    )

    data class Theme(
        @SerializedName("color")
        val color: String = "",

        @SerializedName("cover_image")
        val coverImage: String = "",

        @SerializedName("id")
        val id: Int = 0,

        @SerializedName("title")
        val title: String = ""
    )

    data class DeadLine(
        @SerializedName("color")
        val color: String = "",

        @SerializedName("message")
        val message: String = "",

        @SerializedName("type")
        val type: String = "",

        @SerializedName("hex_color")
        val hexColor: String = ""
    )
}