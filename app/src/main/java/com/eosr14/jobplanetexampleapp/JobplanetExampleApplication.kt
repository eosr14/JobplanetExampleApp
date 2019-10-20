package com.eosr14.jobplanetexampleapp

import android.app.Application
import android.content.Context
import com.eosr14.jobplanetexampleapp.network.RetrofitClient
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import com.facebook.imagepipeline.cache.MemoryCacheParams
import com.facebook.imagepipeline.core.ImagePipelineConfig

class JobplanetExampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this, getImagePipelineConfig(this))
    }

    private fun getImagePipelineConfig(context: Context): ImagePipelineConfig {
        val maxMemoryCacheSize = (Runtime.getRuntime().maxMemory().toInt()) / 4
        return OkHttpImagePipelineConfigFactory
            .newBuilder(context, RetrofitClient().provideOkHttpClient())
            .setBitmapMemoryCacheParamsSupplier {
                MemoryCacheParams(
                    maxMemoryCacheSize,
                    Int.MAX_VALUE,
                    maxMemoryCacheSize,
                    Int.MAX_VALUE,
                    Int.MAX_VALUE
                )
            }
            .setMainDiskCacheConfig(
                DiskCacheConfig.newBuilder(context)
                    .setBaseDirectoryName("imageCache")
                    .setBaseDirectoryPath(cacheDir)
                    .build()
            )
            .setDownsampleEnabled(true)
            .build()
    }

    companion object {
        private lateinit var instance: JobplanetExampleApplication

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

}