package com.kuaishou.mynews

import android.app.Application
import com.tencent.mmkv.MMKV

class AppContext: Application() {
    override fun onCreate() {
        super.onCreate()
        initMMKV()
    }

    private fun initMMKV() {
        val rootDir = MMKV.initialize(this)
    }


}