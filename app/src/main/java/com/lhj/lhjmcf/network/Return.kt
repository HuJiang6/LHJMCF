package com.lhj.lhjmcf.network

import java.io.Serializable

/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:
 */
data class Return (var msg : String, var retCode : String) : Serializable {

    /**
     * 返回结果集
     */
    data class Result(var categoryInfo : String, var ctgId : String, var nam : String) : Serializable
}