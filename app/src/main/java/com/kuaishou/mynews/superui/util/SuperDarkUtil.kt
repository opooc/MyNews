package com.kuaishou.mynews.superui.util

import android.content.Context
import android.content.res.Configuration

object SuperDarkUtil {
    fun isDark(context: Context): Boolean {
        // 位运算符and
        return context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
}