package com.kuaishou.mynews.component.guide

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kuaishou.mynews.component.adapter.BaseFragmentPagerAdapter

/**
 * 引导页面适配器
 */
class GuideAdapter(context: Context, fragmentManager: FragmentManager):
    BaseFragmentPagerAdapter<Int>
    (context, fragmentManager) {
//    private var datum :MutableList<Int> = mutableListOf()


    // 每一个是什么，这个类似于有个复用池
    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(getData(position))
    }


}