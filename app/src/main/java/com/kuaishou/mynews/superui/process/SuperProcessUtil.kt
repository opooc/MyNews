package com.kuaishou.mynews.superui.process


import android.os.Process

/**
 * 进程工具类
 */
object SuperProcessUtil {
    /**
     * 杀死当前应用
     */
    fun killApp() {
        Process.killProcess(Process.myPid())
    }
}