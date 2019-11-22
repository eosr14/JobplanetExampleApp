package com.eosr14.jobplanetexampleapp.network.services

import com.eosr14.jobplanetexampleapp.model.Search
import io.reactivex.Single
import retrofit2.http.GET

interface CompanySearchService {

    @GET("/")
    fun requestCompanySearch(): Single<Search>

}