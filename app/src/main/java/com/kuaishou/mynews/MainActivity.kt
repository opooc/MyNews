package com.kuaishou.mynews

import android.util.Log
import com.kuaishou.mynews.activity.BaseViewModelActivity
import com.kuaishou.mynews.component.guide.GuideActivity
import com.kuaishou.mynews.component.login.LoginHomeActivity
import com.kuaishou.mynews.config.Config
import com.kuaishou.mynews.databinding.ActivityMainBinding
import com.kuaishou.mynews.util.Constant
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : BaseViewModelActivity<ActivityMainBinding>() {
    override fun initDatum() {
        super.initDatum()
        test()
        val action = intent.action
        if (Constant.ACTION_LOGIN == action) {
            startActivity(LoginHomeActivity::class.java)
        }
    }
    private fun test() {
        val client = OkHttpClient()
        val url = Config.ENDPOINT + "v1/contents"
        Log.d("","123123123")
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(GuideActivity.TAG, "onFailure:123 " + e.localizedMessage)

            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(GuideActivity.TAG, "onResponse: " + response.body!!.string())
            }

        })
    }
}