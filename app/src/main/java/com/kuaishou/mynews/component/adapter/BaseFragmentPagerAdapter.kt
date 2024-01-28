package com.kuaishou.mynews.component.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * 通用FragmentPagerAdapter
 * 主要是创建了列表实现了通用的方法
 * 直接用FragmentPagerAdapter有可能有内存泄漏
 * 所以使用FragmentStatePagerAdapter
 */
abstract class BaseFragmentPagerAdapter<T>(val context: Context, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    private var datum: MutableList<T> = mutableListOf()

    /**
     * 有多少个
     *
     * @return
     */
    override fun getCount(): Int {
        return datum.size
    }

    /**
     * 设置数据
     *
     * @param datum
     */
    fun setDatum(datum: MutableList<T>) {
        this.datum.clear()
        this.datum.addAll(datum)
        notifyDataSetChanged()
    }

    /**
     * 获取当前位置的数据
     *
     * @param position
     * @return
     */
    fun getData(position: Int): T {
        return datum[position]
    }
}