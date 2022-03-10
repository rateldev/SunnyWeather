package com.ratelsx.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * 全局Context
 */
class SunnyWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}