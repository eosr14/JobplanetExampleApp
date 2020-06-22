package com.eosr14.jobplanetexampleapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.common.VerticalMarginDecoration
import com.eosr14.jobplanetexampleapp.common.base.BaseActivity
import com.eosr14.jobplanetexampleapp.common.base.BaseRecyclerViewAdapter
import com.eosr14.jobplanetexampleapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_horizontal_theme.*

class MainActivity : BaseActivity(), MainViewModelInterface {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this@MainActivity,
            R.layout.activity_main
        ).apply {
            mainViewModel = MainViewModel(this@MainActivity)
            bindView()
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }
    }

    private fun bindView() {
        recyclerview_main.run {
            addItemDecoration(VerticalMarginDecoration(this@MainActivity))
            layoutManager = LinearLayoutManager(context).apply { orientation = RecyclerView.VERTICAL }
            adapter = MainListAdapter(object : BaseRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(view: View, position: Int, adapter: BaseRecyclerViewAdapter<*, *>) {
                    // TODO : 상세 페이지로 이동
                    // TODO : TEST1
                    // TODO : TEST2
                }
            })
        }

        mainViewModel.isProgress.observe(this@MainActivity, Observer {
            it?.let { isProgress ->
                when (isProgress) {
                    true -> progressDialog.show()
                    false -> progressDialog.cancel()
                }
            }
        })
    }


    // MainViewModelInterface [--
    override fun showErrorToast() = showNetworkErrorToast()
    // --] MainViewModelInterface

}

