package com.kuaishou.mynews.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.kuaishou.mynews.util.ReflectUtil

open class BaseViewModelActivity<VB : ViewBinding> : BaseLogicActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //调用inflate方法，创建viewBinding
        binding = ReflectUtil.newViewBinding(layoutInflater, javaClass) // javaClass代表当前的类

        setContentView(binding.root)
    }
}