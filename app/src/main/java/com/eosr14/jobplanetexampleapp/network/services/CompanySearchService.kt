package com.eosr14.jobplanetexampleapp.network.services


import com.eosr14.jobplanetexampleapp.model.CompanySearch
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface CompanySearchService {

    @GET("/")
    fun requestCompanySearch(): Single<CompanySearch>

//    @GET("/")
//    fun requestCompanySearch(): Call<CompanySearch>


//    fun login(
//        @Query("phone") phone: String,
//        @Query("password") password: String
//    ): Call<LoginResponse>

}