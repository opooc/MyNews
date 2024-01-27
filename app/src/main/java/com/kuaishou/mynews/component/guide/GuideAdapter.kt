package com.kuaishou.mynews.component.guide

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * 引导页面适配器
 */
class GuideAdapter(context: Context, fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    private var datum :MutableList<Int> = mutableListOf()

    // 下面这俩方法必须实现.
    // 一共多少个
    override fun getCount(): Int {
        return datum.size
    }
    // 每一个是什么，这个类似于有个复用池
    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(datum[position])
    }

    fun setDatum(datum: MutableList<Int>) {
        this.datum.clear()
        this.datum.addAll(datum)
        notifyDataSetChanged()
    }
}