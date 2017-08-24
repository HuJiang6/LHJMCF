package com.lhj.lhjmcf.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity



/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:基础Activity，设置Activity共有的属性。比如跳转动画等
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //        if (AppApplication.flag == -1) {//flag为-1说明程序被杀掉
        //            protectApp();
        //        }
    }

    override fun getResources(): Resources { //屏蔽系统字体大小
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

    //系统内存不足，强杀app；重启app以后让app从走启动过程
//    protected void protectApp() {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//清空栈里MainActivity之上的所有activty
//        startActivity(intent);
//        finish();
//    }
}