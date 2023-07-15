package com.vip.base.config

import android.app.Application
import android.content.Context
import android.view.View
import com.vip.base.R
import com.vip.base.listener.BaseActivityListener

/**
 *AUTHOR:AbnerMing
 *DATE:2021/11/8
 *INTRODUCE:初始化页面title
 */
object BaseConfig {
    @JvmStatic
    var statusBarColor = R.color.base_color_ffffff//状态栏背景颜色

    @JvmStatic
    var statusBarDarkMode = true//状态栏文字颜色

    @JvmStatic
    var actionBarHeight = 0//ActionBar的高度

    @JvmStatic
    var actionBarBg = 0//ActionBar的背景颜色

    @JvmStatic
    var titleColor = 0//ActionBar 中间title的颜色

    @JvmStatic
    var titleSize = 0f//ActionBar 中间title的大小

    @JvmStatic
    var leftIcon = View.NO_ID//左侧的图标

    @JvmStatic
    var leftIconWidth = 0//左边图片的宽度

    @JvmStatic
    var leftIconHeight = 0//左边图片的高度

    @JvmStatic
    var leftIconMarginLeft = 0//左边距离左边的距离

    @JvmStatic
    var rightIconMarginRight = 0//右边距离左边的距离


    private var mActivityListener: BaseActivityListener? = null
    fun addActivityListener(mActivityListener: BaseActivityListener) {
        this.mActivityListener = mActivityListener

    }

    fun getActivityListener(): BaseActivityListener? {
        return mActivityListener
    }


    private var mApplication: Application? = null
    fun setBaseContext(application: Application) {
        mApplication = application
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取全局上下文
     */
    fun getBaseContext(): Context? {
        return mApplication?.applicationContext
    }

}