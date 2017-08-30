package com.lhj.lhjmcf.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription


/**
 * Created by 陆胡江 on 2017/8/24.
 * Desc:
 */
open class BaseFragment : Fragment() {
    val mCompositeSubscription: CompositeSubscription = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkInitParam()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setOnClick()
        setOnRxBus()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    /**
     * desc:获取参数
     */
    protected fun checkInitParam() {


    }


    /**
     * desc:初始化View的一些数据
     */
    protected fun initView() {


    }

    /**
     * desc:设置点击监听
     */
    protected fun setOnClick() {

    }


    /**
     * desc:设置总线事件
     */
    protected fun setOnRxBus() {

    }


    fun startActivity(activity: Class<*>) {
        val intent = Intent()
        intent.setClass(getActivity(), activity)
        startActivity(intent)
    }

    fun startActivity(activity: Class<*>, args: Bundle) {
        val intent = Intent()
        //intent.putExtra(GlobalConstant.EXTRA, args);
        intent.setClass(getActivity(), activity)
        startActivity(intent)
    }

    fun startFragment(containerID: Int, fragment: Fragment) {

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(containerID, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()

    }

    fun startFragment(containerID: Int, fragment: Fragment, argBundle: Bundle?) {

        if (argBundle != null) {
            fragment.arguments = argBundle
        }
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(containerID, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()

    }

    fun startChildFragment(containerID: Int, fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(containerID, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()

    }

    fun startChildFragment(containerID: Int, fragment: Fragment, argBundle: Bundle?) {

        if (argBundle != null) {
            fragment.arguments = argBundle
        }
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(containerID, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

    fun onBackPressed(): Boolean {
        return false
    }


    open fun <M> addSubscription(observable: Observable<M>, subscriber: Subscriber<M>) {
        mCompositeSubscription.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber))
    }
}