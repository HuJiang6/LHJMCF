package com.lhj.lhjmcf.network.retrofit

/**
 * Created by 陆胡江 on 2017/8/30.
 * Desc:
 */
data class WeatherinfoModel constructor(val weatherinfo: WeatherinfoBean) {
    data class WeatherinfoBean(
            val city: String,
            val cityid: String
    )
}