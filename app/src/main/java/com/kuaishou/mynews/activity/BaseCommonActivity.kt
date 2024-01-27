package com.kuaishou.mynews.activity

import android.content.Intent

open class BaseCommonActivity : BaseActivity() {
    /**
     * 启动界面
     * @param clazz
     */
    protected fun startActivity(clazz: Class<*>) {
        //创建Intent
        val intent = Intent(this, clazz)

        //启动界面
        startActivity(intent)
    }

    /**
     * 启动界面并关闭当前界面
     * @param clazz
     */
    fun startActivityAfterFinishThis(clazz: Class<*>) {
        startActivity(clazz)

        //关闭当前界面
        finish()
    }
}