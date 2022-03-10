package com.ratelsx.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 网络请求的API封装
 */
object SunnyWeatherNetwork {

    // 动态代理对象
    private val placeService = ServiceCreator.create<PlaceService>()

    // 声明为挂起函数
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    // 如果响应体不为空则返回数据，为空则抛出异常
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("响应体为空"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }


}