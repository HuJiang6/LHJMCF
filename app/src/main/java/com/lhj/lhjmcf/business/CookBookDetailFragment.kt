package com.lhj.lhjmcf.business

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lhj.lhjmcf.R
import com.lhj.lhjmcflibrary.fragment.FragmentUtil

/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:菜谱详细做法，根据菜谱ID查询菜谱详情。
 */
class CookBookDetailFragment : Fragment() {

    companion object {
        fun loadCookBookDetailListFragment(fragment: Fragment) {
            val bundle = Bundle()
            FragmentUtil.loadFragment(
                    fragment.fragmentManager,
                    CookBookDetailFragment::class.java.canonicalName,
                    R.id.classifyFragment,
                    bundle
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(this.context)
        textView.text = "CookBookDetailFragment"

        return textView
    }
}