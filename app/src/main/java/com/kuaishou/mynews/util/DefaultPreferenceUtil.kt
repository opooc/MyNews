package com.kuaishou.mynews.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class DefaultPreferenceUtil(context: Context) {
    private var context: Context
    private val preference: SharedPreferences

    init {
        this.context = context.applicationContext  // 直接使用context会有内存泄漏
        preference = PreferenceManager.getDefaultSharedPreferences(this.context) // 获取系统偏好 , 默认名称
//        preference = this.context.getSharedPreferences("xx", Context.MODE_PRIVATE) // 自定义名称
    }

    /**
     * 获取是否同意了用户条款
     *
     * @return
     */
    val isAcceptTermsServiceAgreement: Boolean
        get() = preference.getBoolean(TERMS_SERVICE, false) // 获取这个key对应的值，如果没有默认返回false

    // 设置用户是否同意了
    fun setAcceptTermsServiceAgreement() {
        putBoolean(TERMS_SERVICE, true)
    }

    //region 辅助方法
    private fun putBoolean(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }

    companion object {
        private const val NAME = "kuaishou_news"
        private const val TERMS_SERVICE = "TERMS_SERVICE"
        private const val KEY_MOBILE_NETWORK_PLAY = "mobile_network_play"

        private var instance: DefaultPreferenceUtil? = null // 如果不能为空，使用initlazy 初始化

        // 通过context可以获取应用的信息，图标 版本 缓存目录等等
        @Synchronized
        fun getInstance(context: Context): DefaultPreferenceUtil {
            if (instance == null) {
                instance = DefaultPreferenceUtil(context)
            }
            return instance!!
        }
    }
}