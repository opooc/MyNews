package com.kuaishou.mynews.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    /**
     * 初始化控件 // protected模式，open 表示可以
     */
    protected open fun initViews() {
        print("Base---initViews")
    }

    /**
     * 设置数据
     */
    protected open fun initDatum() {}

    /**
     * 设置监听
     */
    protected open fun initListeners() {}

    // 通常用于初始化界面上的组件
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
        initDatum()
        initListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}