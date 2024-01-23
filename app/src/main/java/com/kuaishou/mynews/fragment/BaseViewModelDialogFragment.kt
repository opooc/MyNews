package com.kuaishou.mynews.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.kuaishou.mynews.util.ReflectUtil

abstract class BaseViewModelDialogFragment<VB : ViewBinding> : BaseCommonDialogFragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ReflectUtil.newViewBinding(layoutInflater, this.javaClass)
    }

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // 防止内存泄漏
    }
}