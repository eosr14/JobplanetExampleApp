package com.eosr14.jobplanetexampleapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eosr14.jobplanetexampleapp.common.base.BaseViewModel
import com.eosr14.jobplanetexampleapp.model.CompanySearch
import com.eosr14.jobplanetexampleapp.network.RetrofitManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val mainViewModelInterface: MainViewModelInterface
) : BaseViewModel() {

    private val _searchItems = MutableLiveData<List<CompanySearch.Items>>(mutableListOf())
    val searchItems: LiveData<List<CompanySearch.Items>> get() = _searchItems

    init {
        requestCompanySearch()
    }

    fun requestCompanySearch() {
        addDisposable(
            RetrofitManager.requestCompanySearch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _searchItems.value = it.items
                }, {
                })
        )
    }


    fun onClickNotification() {}
    fun onClickMyInfo() {}

}