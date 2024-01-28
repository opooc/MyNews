package com.kuaishou.mynews.component.guide

import android.content.Intent
import android.util.Log
import com.kuaishou.mynews.MainActivity
import com.kuaishou.mynews.R
import com.kuaishou.mynews.activity.BaseViewModelActivity
import com.kuaishou.mynews.config.Config
import com.kuaishou.mynews.databinding.ActivityGuideBinding
import com.kuaishou.mynews.util.Constant
import com.kuaishou.mynews.util.PreferenceUtil
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

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
            val intent = Intent(this, MainActivity::class.java)
            intent.action = Constant.ACTION_LOGIN
            startActivity(intent)
            finish()
        }
        binding.experienceNow.setOnClickListener {
            setShowGuide()
            startActivityAfterFinishThis(MainActivity::class.java)


        }
    }
    private fun setShowGuide() {
        PreferenceUtil.setShowGuide(false)
    }

    companion object {
        const val TAG = "GuideActivity"
    }
}