package com.eosr14.jobplanetexampleapp.common

import android.graphics.drawable.Animatable
import android.net.Uri
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eosr14.jobplanetexampleapp.R
import com.eosr14.jobplanetexampleapp.model.CompanySearch
import com.eosr14.jobplanetexampleapp.ui.main.MainHorizontalThemeAdapter
import com.eosr14.jobplanetexampleapp.ui.main.MainListAdapter
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.RotationOptions
import com.facebook.imagepipeline.image.ImageInfo
import com.facebook.imagepipeline.request.ImageRequestBuilder
import java.text.DecimalFormat


object DataBindingComponents {

    @JvmStatic
    @BindingAdapter("searchItems")
    fun setSearchItems(recyclerView: RecyclerView, items: MutableList<CompanySearch.Items>) {
        recyclerView.adapter?.let { adapter ->
            if (adapter is MainListAdapter) {
                adapter.setItems(items)
                recyclerView.scheduleLayoutAnimation()
            }
        }
    }

    @JvmStatic
    @BindingAdapter("urlToImage")
    fun setUrlToImage(view: SimpleDraweeView, url: String) {
        val imageRequest = ImageRequestBuilder
            .newBuilderWithSource(Uri.parse(url))
            .setRotationOptions(RotationOptions.autoRotate())
            .setProgressiveRenderingEnabled(true)
            .build()

        view.controller = Fresco.newDraweeControllerBuilder().run {
            this.oldController = view.controller
            this.imageRequest = imageRequest
            this.autoPlayAnimations = true
            this.controllerListener = object : BaseControllerListener<ImageInfo>() {
                override fun onFinalImageSet(
                    id: String?,
                    imageInfo: ImageInfo?,
                    animatable: Animatable?
                ) {
                    super.onFinalImageSet(id, imageInfo, animatable)
                    imageInfo?.let { info ->
                        view.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                        view.aspectRatio = info.width.toFloat() / info.height
                    }
                }
            }
            this.build()
        }
    }

    @JvmStatic
    @BindingAdapter("salaryAvg")
    fun setTextSalaryAvg(textView: TextView, salaryAvg: Int) {
        textView.text = String.format(
            textView.context.getString(
                R.string.main_company_salary_avg,
                DecimalFormat("###,###").format(salaryAvg)
            ), TextView.BufferType.SPANNABLE
        )
    }

    @JvmStatic
    @BindingAdapter("salaryValue")
    fun setSalaryValue(textView: TextView, salaryValue: Int) {
        textView.text = DecimalFormat("###,###").format(salaryValue)
    }


}