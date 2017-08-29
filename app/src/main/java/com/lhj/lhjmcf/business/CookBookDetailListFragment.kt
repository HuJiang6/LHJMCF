package com.lhj.lhjmcf.business

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lhj.lhjmcf.base.BaseFragment
import com.lhj.lhjmcf.base.ClassifyNoToolbarActivity
import com.lhj.lhjmcf.constants.GlobalConstant


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

        return textView
    }
}