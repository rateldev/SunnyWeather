package com.ratelsx.sunnyweather.logic.network

import com.ratelsx.sunnyweather.SunnyWeatherApplication
import com.ratelsx.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 城市数据网络层接口
 */
interface PlaceService {

    /**
     * 城市数据接口
     * @param query 需要查询的城市
     */
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}