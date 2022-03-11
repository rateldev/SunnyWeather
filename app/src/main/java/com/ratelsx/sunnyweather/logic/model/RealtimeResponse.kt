package com.ratelsx.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 实时天气信息数据类
 * @param status 状态码
 * @param result 数据
 */
data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: Realtime)
    data class Realtime(
        val temperature: Float,
        val skycon: String,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)
    data class AQI(val chn: Float)
}