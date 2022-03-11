package com.ratelsx.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 未来几天天气数据类
 */
data class DailyResponse(val status: String, val result: Result) {
    data class Result(val daily: Daily)
    data class Daily(
        val temperature: List<Temperature>,
        val skycon: List<Skycon>,
        @SerializedName("life_index") val lifeIndex: LifeIndex
    )

    data class Temperature(val max: Float, val min: Float)
    data class Skycon(val date: Date, val value: String)
    data class LifeIndex(
        val ultraviolet: List<LifeDescription>,
        val carWashing: List<LifeDescription>,
        val dressing: List<LifeDescription>,
        val coldRisk: List<LifeDescription>
    )

    data class LifeDescription(val desc: String)
}