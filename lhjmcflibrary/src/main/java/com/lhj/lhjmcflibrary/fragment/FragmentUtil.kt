package com.lhj.lhjmcflibrary.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.lhj.lhjmcflibrary.R

/**
 * Created by 陆胡江 on 2017/8/28.
 * Desc:fragment工具，相关fragment的相关操作都封装在这个类里面
 */
class FragmentUtil {
    companion object {
        /**
         * 加载Fragment, 并加入回退栈
         *
         * @param manager
         * @param canonicalName
         * @param containerID
         * @param bundle
         */
        fun loadFragment(manager: FragmentManager, canonicalName: String,
                         containerID: Int, bundle: Bundle?) {
            try {
                val fragmentClass = Class.forName(canonicalName)
                val fragment = fragmentClass.newInstance() as Fragment
                val transaction = manager.beginTransaction()

                fragment.arguments = bundle

                transaction.setCustomAnimations(
                        R.anim.slide_right_in,
                        R.anim.slide_left_out,
                        R.anim.back_left_in,
                        R.anim.back_right_out
                )
                transaction.replace(containerID, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }

        /**
         * 加载Fragment, 不添加到回退栈
         *
         * @param manager
         * @param canonicalName
         * @param containerID
         * @param argBundle
         */
        fun loadFragmentNoBackStack(manager: FragmentManager, canonicalName: String,
                                    containerID: Int, argBundle: Bundle?) {
            try {
                val fragmentClass = Class.forName(canonicalName)
                val fragment = fragmentClass.newInstance() as Fragment
                val transaction = manager.beginTransaction()

                fragment.arguments = argBundle

                transaction.replace(containerID, fragment)
                transaction.commit()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }
    }
}