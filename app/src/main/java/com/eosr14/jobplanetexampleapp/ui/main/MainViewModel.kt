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

                    model.items.run {
                        for (item in model.items) {
                            android.util.Log.d("eosr14", "CompanyType Test1 = ${item.cellType} ${ItemType.Type.COMPANY.cellType}")
                            when (item.cellType) {
                                ItemType.Type.COMPANY.cellType -> item.companyItemType = ItemType.Type.COMPANY
                                ItemType.Type.HORIZONTAL_THEME.cellType -> item.companyItemType = ItemType.Type.HORIZONTAL_THEME
                                ItemType.Type.JOB_POSTING.cellType -> item.companyItemType = ItemType.Type.JOB_POSTING
                                ItemType.Type.INTERVIEW.cellType -> item.companyItemType = ItemType.Type.INTERVIEW
                                ItemType.Type.SALARY.cellType -> item.companyItemType = ItemType.Type.SALARY
                                ItemType.Type.REVIEW.cellType -> item.companyItemType = ItemType.Type.REVIEW
                                else -> item.companyItemType = ItemType.Type.EMPTY
                            }

                            android.util.Log.d("eosr14", "CompanyType Test2 = ${item.companyItemType}")
                        }

                        _searchItems.value = this
                    }

//                    _searchItems.value = model.items

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