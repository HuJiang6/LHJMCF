package com.lhj.lhjmcf.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 陆胡江 on 2017/8/30.
 * Desc:初始化Retrofit
 */
class InitRetrofit {
    companion object {
        private var SERVICE: ApiService? = null
        val BASE_URL = "sadsd"
        /**
         * 请求超时时间
         */
        private val DEFAULT_TIMEOUT = 10000

        fun getDefault() : ApiService? {
            if (SERVICE == null) {
                //手动创建一个OkHttpClient并设置超时时间
                val httpClientBuilder = OkHttpClient.Builder()
                httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)

                /**
                 * 拦截器
                 */
                httpClientBuilder.addInterceptor { chain ->
                    val request = chain.request()

                    //                    Request.Builder requestBuilder = request.newBuilder();
                    //                    RequestBody formBody = new FormBody.Builder()
                    //                            .add("1","2")
                    //                            .build();

                    val authorizedUrlBuilder = request.url()
                            .newBuilder()
                            //添加统一参数 如手机唯一标识符,token等
                            .addQueryParameter("key1", "value1")
                            .addQueryParameter("key2", "value2")

                    val newRequest = request.newBuilder()
                            //对所有请求添加请求头
                            .header("mobileFlag", "adfsaeefe").addHeader("type", "4")
                            .method(request.method(), request.body())
                            .url(authorizedUrlBuilder.build())
                            .build()

                    //                    okhttp3.Response originalResponse = chain.proceed(request);
                    //                    return originalResponse.newBuilder().header("mobileFlag", "adfsaeefe").addHeader("type", "4").build();
                    chain.proceed(newRequest)
                }


                SERVICE = Retrofit.Builder()
                        .client(httpClientBuilder.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .baseUrl(BASE_URL)
                        .build().create(ApiService::class.java)
            }
            return SERVICE
        }
    }

}