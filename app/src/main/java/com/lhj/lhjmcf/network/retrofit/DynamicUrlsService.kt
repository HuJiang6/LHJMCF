package com.lhj.lhjmcf.network.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Created by 陆胡江 on 2017/8/30.
 * Desc:Retrofit动态Url请求接口
 */
interface DynamicUrlsService<T> {
    @GET
    fun DynamicUrlsGet (@Url url: String) : Call<T>

    @POST
    fun DynamicUrlsPost (@Url url: String) : Call<T>
}