package com.lhj.lhjmcf.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.WindowManager
import com.lhj.lhjmcf.R
import com.lhj.lhjmcf.constants.GlobalConstant
import java.lang.ref.WeakReference


/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:分类显示Activity,可根据Intent传入的信息打开对应的fragment
 */
class ClassifyNoToolbarActivity : BaseActivity() {
    protected var mFragment: WeakReference<Fragment>? = null
    private var activityOnWindowFocusChanged: OnActivityOnWindowFocusChanged? = null
    private var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classify_no_toolbar)

        val fm = supportFragmentManager
        val fragment = fm.findFragmentById(R.id.classifyFragment)

        if (fragment == null) {
            initFromIntent(intent)
        }

    }

    protected fun initFromIntent(data: Intent?) {
        if (data == null) {
            throw RuntimeException(
                    "you must provide a page info to display")
        }

        try {
            val fragmentName = data.getStringExtra(GlobalConstant.FRAGMENT)
            if (fragmentName == null || "" == fragmentName) {
                throw IllegalArgumentException("can not find page fragmentName")
            }
            val fragmentClass = Class.forName(fragmentName)
            val fragment = fragmentClass.newInstance() as Fragment

            val args = data.getBundleExtra(GlobalConstant.EXTRA)
            if (args != null) {
                fragment.arguments = args
            }

            val trans = supportFragmentManager
                    .beginTransaction()
            trans.replace(R.id.classifyFragment, fragment)
            trans.commitAllowingStateLoss()

            mFragment = WeakReference(fragment)

        } catch (e: ClassNotFoundException) {
            LogUtil.e("未找到对应的fragment")
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

    }

    override fun onBackPressed() {

        //         List<Fragment> fragments =  getSupportFragmentManager().getFragments();
        //        if(fragments != null ) {
        //            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //            transaction.remove(fragments.get(fragments.size() - 1));
        //            transaction.commit();
        //        }

        val fragment = supportFragmentManager.findFragmentById(R.id.classifyFragment)
        if (fragment is BaseFragment) {
            if (!fragment.onBackPressed()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }


        //        if (mFragment != null && mFragment.get() != null
        //                && mFragment.get() instanceof BaseFragment) {
        //            BaseFragment bf = (BaseFragment) mFragment.get();
        //            if (!bf.onBackPressed()) {
        //                super.onBackPressed();
        //            }
        //        } else {
        //            super.onBackPressed();
        //        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK
//                && mFragment.get() instanceof BaseFragment) {
//            ((BaseFragment) mFragment.get()).onBackPressed();
//        }
//        return super.onKeyDown(keyCode, event);
//    }


    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 为获取view高度而设定的接口回调，
     * 给fragment中不能掉用onWindowFocusChanged该方法使用
     */
    fun windowFocusChanged(activityOnWindowFocusChanged: OnActivityOnWindowFocusChanged) {
        this.activityOnWindowFocusChanged = activityOnWindowFocusChanged
    }


    /**
     * 当前窗体得到或失去焦点的时候的时候调用。
     * 这是这个活动是否是用户可见的最好的指标。
     * 默认的实现清除重点跟踪状态，所以应该总是被调用。
     * 请注意，这提供了有关整体焦点状态信息，这是独立管理活动的生命周期
     */
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (activityOnWindowFocusChanged != null) {
            if (flag) {
                activityOnWindowFocusChanged!!.onWindowFocusChangedListener(hasFocus)
                flag = false//保证就调用一次
            }

        }

    }
}