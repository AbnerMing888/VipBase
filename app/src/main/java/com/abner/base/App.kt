package com.abner.base

import android.app.Application
import com.vip.base.config.BaseConfig

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/30
 *INTRODUCE:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //初始化标题栏
        BaseConfig.apply {
            actionBarBg = R.color.purple_700
            titleColor = R.color.base_color_ffffff
            statusBarColor = R.color.purple_700
            statusBarDarkMode = false
            leftIcon = R.drawable.ic_back
        }
    }
}