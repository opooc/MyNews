package com.kuaishou.mynews.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {
    /**
     * 找控件
     */
    protected open fun initViews() {}

    /**
     * 设置数据
     */
    protected open fun initDatum() {}

    /**
     * 设置监听器
     */
    protected open fun initListeners() {}

    /**
     * 返回要显示的控件
     * onCreateView方法是在Fragment创建时调用的，它的作用是创建Fragment的视图，并将其返回给调用者
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        onCreateView(inflater, container, savedInstanceState)
        // 1. xml怎么转换成布局？
        val view = getLayoutView(inflater, container, savedInstanceState)
        return view// 该方法返回以后，才会展示在界面上
    }

    /**
     * 做成接口的形式。
     */
    open abstract fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    /**
     * 视图创建完后调用
     * onViewCreated方法是在Fragment的视图创建完成后调用的，它的作用是初始化Fragment的视图，并将其与Fragment进行绑定。
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews() // 视图都创建完了，为什么还要初始化呢
        initDatum()
        initListeners()
    }
}