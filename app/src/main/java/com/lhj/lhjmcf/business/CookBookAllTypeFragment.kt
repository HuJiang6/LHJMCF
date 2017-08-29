package com.lhj.lhjmcf.business

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:菜谱（标签）类型界面，查询菜谱的所有分类。
 */
class CookBookAllTypeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView: TextView = TextView(this.context)
        textView.text = "CookBookAllTypeFragment"

        return textView
    }
}