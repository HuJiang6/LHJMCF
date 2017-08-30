package com.lhj.lhjmcf.network.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by 陆胡江 on 2017/8/30.
 * Desc:
 */
interface ApiStores {
    companion object {
        //baseUrl
        val API_SERVER_URL = "http://www.weather.com.cn/"
    }
    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadData(@Path("cityId") cityId: String): Observable<WeatherinfoModel>
}