package com.lhj.lhjmcf.network

/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:
 */
data class HttpResponse<T> (var mReturn : Return, var data : T)