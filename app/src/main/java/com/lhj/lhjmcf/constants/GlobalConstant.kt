package com.lhj.lhjmcf.constants

/**
 * Created by 陆胡江 on 2017/8/9.
 * Desc:全局常量
 */
object GlobalConstant {
    //Mob.com相关常量
    val APP_KEY = "200a4ecc2985c"
    val APP_SECRET = "620b7f9442a6ce1f27f2ed0dbba7def9"
    //错误码
    /**
     * appkey不合法
     */
    val error_code_10001 = "10001"
    /**
     * 接口维护
     */
    val error_code_10020 = "10020"
    /**
     * 接口停用
     */
    val error_code_10021 = "10021"
    /**
     * 成功
     */
    val error_code_200 = "200"
    /**
     * 查询不到相关数据
     */
    val error_code_20101 = "20101"

    //************************************************
    //Application全局常量
    //Bundle常量
    /**
     * 两个界面传递实体的bundle
     */
    val BUNDLE_ENTITY = "bundle_entity"

    /**
     * 两个界面传递标志位的bundle（表明从哪里跳转过去的）
     */
    val BUNDLE_FLAG = "bundle_flag"

    /**
     * 两个界面传递的普通参数key
     */
    val BUNDLE_PARAMETER = "bundle_parameter"

    val EXTRA = "extra"

    val FRAGMENT = "fragment"
}