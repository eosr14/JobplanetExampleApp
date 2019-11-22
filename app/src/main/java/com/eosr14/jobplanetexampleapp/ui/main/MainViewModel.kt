package com.eosr14.jobplanetexampleapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eosr14.jobplanetexampleapp.common.base.BaseViewModel
import com.eosr14.jobplanetexampleapp.model.ItemType
import com.eosr14.jobplanetexampleapp.model.Search
import com.eosr14.jobplanetexampleapp.network.RetrofitManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val mainViewModelInterface: MainViewModelInterface
) : BaseViewModel() {

    private val _searchItems = MutableLiveData<List<Search.Items>>(mutableListOf())
    val searchItems: LiveData<List<Search.Items>> get() = _searchItems

    init {
        requestCompanySearch()
    }

    private fun requestCompanySearch() {
        progress.value = true
        addDisposable(
            RetrofitManager.requestCompanySearch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ model ->
                    _searchItems.value = model.items
                    progress.value = false
                }, {
                    progress.value = false
                    mainViewModelInterface.showErrorToast()
                })
        )
    }

    fun onClickNotification() {}

    fun onClickMyInfo() {}

}