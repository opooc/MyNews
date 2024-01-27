package com.kuaishou.mynews.component.guide

import android.os.Bundle
import com.kuaishou.mynews.databinding.FragmentGuideBinding
import com.kuaishou.mynews.fragment.BaseViewModelFragment
import com.kuaishou.mynews.util.Constant

class GuideFragment: BaseViewModelFragment<FragmentGuideBinding>() {
    override fun initDatum() {
        super.initDatum()
        val data = requireArguments().getInt(Constant.ID)
        binding.icon.setImageResource(data)
    }
    // fragment中推荐有nerInstance方法
    // 这里如果是网络图片 ，就传递 字符串
    companion object {
        fun newInstance(data: Int): GuideFragment{
            val args = Bundle()
            args.putInt(Constant.ID, data)
            val fragment = GuideFragment()
            fragment.arguments = args
            return fragment
        }
    }

}