package com.kuaishou.mynews.component.guide

import com.kuaishou.mynews.R
import com.kuaishou.mynews.activity.BaseViewModelActivity
import com.kuaishou.mynews.databinding.ActivityGuideBinding
import com.kuaishou.mynews.util.PreferenceUtil

class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {
    private lateinit var adapter: GuideAdapter

    override fun initDatum() {
        super.initDatum()
        // 创建适配器
        adapter = GuideAdapter(this, supportFragmentManager)
        binding.list.adapter = adapter

        // 让指示器配合工作
        binding.indicator.setViewPager(binding.list)
        // 设置指示为adapter的观察者
        adapter.registerDataSetObserver(binding.indicator.dataSetObserver)

        // 初始化数据
        val datum: MutableList<Int> = ArrayList()
        datum.add(R.drawable.guide1)
        datum.add(R.drawable.guide2)
        datum.add(R.drawable.guide3)
        datum.add(R.drawable.guide4)
        datum.add(R.drawable.guide5)

        adapter.setDatum(datum)
    }

    override fun initListeners() {
        super.initListeners()
        binding.loginOrRegister.setOnClickListener {
            setShowGuide()
        }
        binding.experienceNow.setOnClickListener {
            setShowGuide()
        }
    }
    private fun setShowGuide() {
        PreferenceUtil.setShowGuide(false)
    }
    companion object {

    }
}