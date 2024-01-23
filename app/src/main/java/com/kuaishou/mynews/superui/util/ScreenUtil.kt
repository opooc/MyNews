package com.kuaishou.mynews.superui.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object ScreenUtil {
    fun getScreemWidth(context: Context): Int {
        // 获取window管理器
        val vm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        // 创建显示对象 ,DisplayMetrics包含了当前对象的尺寸信息
        val outDisplayMetrics = DisplayMetrics()

        // 获取默认显示对象, 用来兼容低版本
        vm.defaultDisplay.getMetrics(outDisplayMetrics)

        // 返回屏幕宽度
        return outDisplayMetrics.widthPixels
    }
}