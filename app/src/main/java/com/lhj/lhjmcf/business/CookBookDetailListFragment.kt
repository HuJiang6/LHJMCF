package com.lhj.lhjmcf.business

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lhj.lhjmcf.base.BaseFragment
import com.lhj.lhjmcf.base.ClassifyNoToolbarActivity
import com.lhj.lhjmcf.constants.GlobalConstant
import com.lhj.lhjmcf.network.retrofit.ApiCallback
import com.lhj.lhjmcf.network.retrofit.ApiClient
import com.lhj.lhjmcf.network.retrofit.WeatherinfoModel


/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:菜谱单个类型的菜谱列表，根据标签ID/菜谱名称查询菜谱详情。
 */
class CookBookDetailListFragment : BaseFragment() {
    companion object {
        fun loadCookBookDetailListFragment(context: Context) {
            val bundle = Bundle()
            val intent = Intent()

            intent.setClass(context, ClassifyNoToolbarActivity::class.java)
            intent.putExtra(GlobalConstant.EXTRA, bundle)
            intent.putExtra(GlobalConstant.FRAGMENT, CookBookDetailListFragment::class.java.canonicalName)

            context.startActivity(intent)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(this.context)
        textView.text = "CookBookDetailListFragment"
        textView.setOnClickListener {
            CookBookDetailFragment.loadCookBookDetailListFragment(this)
        }

        //http://wuxiaolong.me/2017/06/03/kotlin4/
        //object为对象表达式
        addSubscription(ApiClient.retrofit().loadData("101190201"), object : ApiCallback<WeatherinfoModel>() {
            override fun onSuccess(model: WeatherinfoModel) {
                Log.d("wxl", "city=" + model.weatherinfo.city + ",cityid=" + model.weatherinfo.cityid)//输出“city=无锡,cityid=101190201”
            }
            override fun onFailure(msg: String?) {
                Log.d("wxl", "onFailure=" + msg)
            }
            override fun onFinish() {
                Log.d("wxl", "onFinish")
            }
        })

        return textView
    }
}