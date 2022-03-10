package com.ratelsx.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 地址数据类
 * @param status 请求的状态
 * @param places 相关地区信息数据
 */
data class PlaceResponse(val status: String, val places: List<Place>)

/**
 * 地区信息数据类
 * @param name 地区名称
 * @param address 地区地址
 */
data class Place(
    val name: String,
    @SerializedName("formatted_address") val address: String,
    val location: Location
)

/**
 * 经纬度数据类
 * @param lat 纬度
 * @param lng 经度
 */
data class Location(val lat: String, val lng: String)