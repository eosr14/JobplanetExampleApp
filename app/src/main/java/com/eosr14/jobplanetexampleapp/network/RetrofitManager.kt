package com.eosr14.jobplanetexampleapp.network


import com.eosr14.jobplanetexampleapp.common.JOB_PLANET_BASE_URL
import com.eosr14.jobplanetexampleapp.model.CompanySearch
import com.eosr14.jobplanetexampleapp.network.services.CompanySearchService
import io.reactivex.Single
import retrofit2.Call

object RetrofitManager {

    private fun provideJobplanet(): CompanySearchService {
        return RetrofitClient().provideRetrofit(JOB_PLANET_BASE_URL).create(CompanySearchService::class.java)
    }

    fun requestCompanySearch(): Single<CompanySearch> {
        return provideJobplanet().requestCompanySearch()
    }
//
//    fun requestCompanySearch(): Call<CompanySearch> {
//        return provideJobplanet().requestCompanySearch()
//    }

}