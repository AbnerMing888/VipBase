package com.abner.base.status

import com.abner.base.R
import com.abner.base.databinding.ActivityStatusBarBinding
import com.vip.base.activity.BaseActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:沉浸式状态栏设置
 */
class StatusBarActivity : BaseActivity<ActivityStatusBarBinding>(R.layout.activity_status_bar) {

    override fun initData() {
        translucentWindow(false)
        hintActionBar()
    }

}