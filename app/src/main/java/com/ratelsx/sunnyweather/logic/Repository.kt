package com.ratelsx.sunnyweather.logic

import androidx.lifecycle.liveData
import com.ratelsx.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * 仓库类
 */
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            // 如果响应状态为ok则使用Result.success()来包装数据
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("响应状态为${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        // 返回数据
        emit(result)
    }
}