package com.kuaishou.mynews.fragment

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes

abstract class BaseCommonDialogFragment : BaseDialogFragment() {
    fun <T : View?> findViewById(@IdRes id: Int): TextView {
        // 这里的view不为空，使用requireView保证不为空
        return this.requireView().findViewById(id)
    }
}