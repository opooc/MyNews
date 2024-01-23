package com.kuaishou.mynews.util

import android.view.LayoutInflater
import java.lang.reflect.ParameterizedType

/**
 * 反射工具类，viewBinding绑定
 */
object ReflectUtil {
    /**
     * 创建view binding
     */
    fun <VB> newViewBinding(layoutInflater: LayoutInflater, clazz: Class<*>): VB {
        return try {
            //获取泛型参数对象
            val type = try {
                clazz.genericSuperclass as ParameterizedType
            } catch (e: ClassCastException) {
                clazz.superclass.genericSuperclass as ParameterizedType
            }

            //type.actualTypeArguments[0]：ViewBinding
            val clazzVB = type.actualTypeArguments[0] as Class<VB>

            //获取inflate方法
            val inflateMethod = clazzVB.getMethod("inflate", LayoutInflater::class.java) // 获取到对应的方法
            inflateMethod.invoke(null, layoutInflater) as VB // 动态调用该方法
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }
}