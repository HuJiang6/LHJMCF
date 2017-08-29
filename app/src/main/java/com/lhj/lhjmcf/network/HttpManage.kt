package com.lhj.lhjmcf.network

import com.lhj.lhjmcf.network.retrofit.CookBookInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by 陆胡江 on 2017/8/9.
 * Desc:
 */
class HttpManage {

    fun reqeust() {
        val retrofit : Retrofit =
                Retrofit.Builder()
                .baseUrl("\"http://apicloud.mob.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val request = retrofit.create(CookBookInterface::class.java)

        //步骤6:发送网络请求(异步)
//        call.enqueue(object : Callback<CookBookBean>() {
//            //请求成功时候的回调
//            fun onResponse(call: Call<CookBookBean>, response: Response<CookBookBean>) {
//                //请求处理,输出结果
//                Log.e("CookBookActivity", response.body().getResult().getChilds().get(0).getChilds()
//                        .get(0).getCategoryInfo().getName())
//            }
//
//            //请求失败时候的回调
//            fun onFailure(call: Call<CookBookBean>, throwable: Throwable) {
//                println("连接失败")
//            }
//        })
    }
}
