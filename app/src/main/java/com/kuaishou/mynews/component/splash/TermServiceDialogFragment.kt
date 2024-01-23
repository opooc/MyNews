package com.kuaishou.mynews.component.splash

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentManager
import com.kuaishou.mynews.R
import com.kuaishou.mynews.databinding.FrafmentDialogTermServiceServiceBinding
import com.kuaishou.mynews.fragment.BaseCommonDialogFragment
import com.kuaishou.mynews.fragment.BaseDialogFragment
import com.kuaishou.mynews.fragment.BaseViewModelDialogFragment
import com.kuaishou.mynews.superui.process.SuperProcessUtil
import com.kuaishou.mynews.superui.util.ScreenUtil
import com.kuaishou.mynews.superui.util.SuperTextUtil


class TermServiceDialogFragment() : BaseViewModelDialogFragment <FrafmentDialogTermServiceServiceBinding> () {
//    private lateinit var disAgreeView: TextView
    private lateinit var onAgreementClickListener: View.OnClickListener
//    private lateinit var primaryView: TextView
//    private lateinit var contentView: TextView

    override fun initViews() {
        super.initViews()
        isCancelable = false  //  设置窗口外不能关闭 相当于java中的setCancelable
//        view.findViewById() // fragment不能直接使用 findViewById获取相应的View
        // 按opention + Enter 可以直接导入局部变量
//        contentView = findViewById<TextView>(R.id.content) // 资源里面找文件使用R.xxx
//        SuperTextUtil.setLinkColor(contentView, resources.getColor(R.color.link)) // getColor这个方法过时了
//        SuperTextUtil.setLinkColor(contentView, getColor(requireContext(), R.color.link)) // 可以在Fragment中使用如下方式获取上下文：
//        primaryView = findViewById<TextView>(R.id.primary)
//        disAgreeView = findViewById<TextView>(R.id.disagree)
        SuperTextUtil.setLinkColor(binding.content, getColor(requireContext(), R.color.link))
    }

    override fun initDatum() {
        super.initDatum()
        val content = Html.fromHtml(getString(R.string.term_service_privacy_content))
//        contentView.text = content
        binding.content.text = content
    }

    override fun initListeners() {
        super.initListeners()
//        primaryView.setOnClickListener {
//            onAgreementClickListener.onClick(it)
//            dismiss()
//        }
//        disAgreeView.setOnClickListener {
//            SuperProcessUtil.killApp()
//        }
        binding.primary.setOnClickListener {
            onAgreementClickListener.onClick(it)
            dismiss()
        }
        binding.disagree.setOnClickListener {
            SuperProcessUtil.killApp()
        }
    }
//    使用bindingView的方式，在加该方法，会被该方法给替换掉。
//    override fun getLayoutView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.frafment_dialog_term_service_service, container, false)
//    // 传false表示，布局转成View后不会放入container中。
//    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        // 表示获取对话框的window属性attributes  如果其中任意一个为空，即为异常。

        /**
         * requireContext() 是一个 Fragment 中的方法，它用于获取 Fragment 的上下文（Context）对象。
         * Context 对象用于访问与应用程序环境相关的信息和资源，如应用程序资源、应用程序级别的操作、Android 系统服务等。如果 Fragment 没有与 Activity 关联或没有有效的上下文，则会引发异常。

        在 Fragment 中使用 requireContext() 方法，而不是 getContext() 方法，是因为在 Androidx 中 getContext() 方法已被弃用。使用 requireContext() 方法可以确保您的代码与未来的 Android 版本兼容。
         */


        // 可以在Fragment中使用如下方式获取根视图：
        //val rootView = requireView()

        params.width = (ScreenUtil.getScreemWidth(requireContext()) * 0.9).toInt()
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as LayoutParams
    }

    // 伴生对象中可以定义方法
    companion object {
        fun show(supportFragmentManager: FragmentManager, onAgreementClickListener: View.OnClickListener) {
            val dialogFragment = TermServiceDialogFragment()
            dialogFragment.onAgreementClickListener = onAgreementClickListener
            dialogFragment.show(supportFragmentManager, "TermServiceDialogFragment")
        }
    }

}