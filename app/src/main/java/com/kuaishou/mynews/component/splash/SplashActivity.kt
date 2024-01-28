package com.kuaishou.mynews.component.splash

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.Manifest
import android.content.Intent
import com.kuaishou.k.StringUtil
import com.kuaishou.mynews.MainActivity
import com.kuaishou.mynews.R
import com.kuaishou.mynews.activity.BaseTitleActivity
import com.kuaishou.mynews.activity.BaseViewModelActivity
import com.kuaishou.mynews.component.guide.GuideActivity
import com.kuaishou.mynews.databinding.ActivitySplashBinding
import com.kuaishou.mynews.superui.util.SuperDarkUtil
import com.kuaishou.mynews.util.DefaultPreferenceUtil
import com.kuaishou.mynews.util.PreferenceUtil
import com.permissionx.guolindev.PermissionX
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlin.math.log

/**
 * 启动界面
 */
class SplashActivity : BaseViewModelActivity<ActivitySplashBinding>() { //这个里边的solashBinding是xml的形式

//    private lateinit var copyrightView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 这里会调用父类的方法，所以父类在调用initView等
        // 要放在onPost方法中，如果父类的这些方法放到onCreate中，会导致kt文件和视图文件还没有绑定前，就去拿view了，会报错
//        setContentView(R.layout.activity_splash) // 将类和布局文件关联起来，后面使用findViewById获取View
        val splashBinding = ActivitySplashBinding.inflate(layoutInflater) // 使用bind的点方法 直接拿 属性
        setContentView(splashBinding.root)
    }

    override fun initViews() {
        super.initViews()
        // 设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)

        if (SuperDarkUtil.isDark(this)) {
            QMUIStatusBarHelper.setStatusBarDarkMode(this)
        } else {
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }
//        copyrightView = findViewById(R.id.copyright)
    }

    override fun initDatum() {
        super.initDatum()

        if (DefaultPreferenceUtil.getInstance(this).isAcceptTermsServiceAgreement) {
            requestPermission()
        } else {
            showTermsServiceAgressDialog() // 用户没有点击过的时候展示弹窗
        }
        //endregion
        //</editor-fold>

//        val currentYear = SuperDateUtil.currentYear()
//        copyrightView.setText(getString(R.string.copyright, currentYear))
    }

    private fun requestPermission() {

        PermissionX.init(this)
            .permissions(
                Manifest.permission.INTERNET,
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
        )
        .request { allGranted, grantedList, deniedList ->
            if (allGranted) {
                prepareNext()
//                binding.root.postDelayed({
//
//                }, 1000)
//                binding.r
            } else {
                //可以在这里弹出提示告诉用户为什么需要权限
                finish()
            }
        }
    }

    private fun prepareNext() {
        if (PreferenceUtil.isShowGuide()) {
            startActivityAfterFinishThis(GuideActivity::class.java)
        } else {
            startActivityAfterFinishThis(MainActivity::class.java)
        }
    }


    private fun showTermsServiceAgressDialog() {
        TermServiceDialogFragment.show(supportFragmentManager) {
            Log.d(TAG, "primary onClick")
            DefaultPreferenceUtil.getInstance(this).setAcceptTermsServiceAgreement()
            requestPermission()
        }
        // fragment在activity中的获取方式是supportFragmentManager
    }

    companion object {
        const val TAG = "SplashActivity"
    }


}