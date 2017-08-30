package com.lhj.lhjmcf.network.retrofit

import com.lhj.lhjmcf.network.HttpResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by 陆胡江 on 2017/8/30.
 * Desc:
 */
interface ApiService {
    @GET("/student/mobileRegister")
    fun login(@Query("phone") phone: String, @Query("password") psw: String): Observable<HttpResponse<String>>


    @GET("top250")
    fun getTopMovie(@Query("start") start: Int, @Query("count") count: Int): Observable<HttpResponse<String>>

    @GET("top250")
    fun getUser(@Query("touken") touken: String): Observable<HttpResponse<String>>
}