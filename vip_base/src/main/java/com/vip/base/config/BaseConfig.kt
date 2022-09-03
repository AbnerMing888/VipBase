package com.vip.base.config

import android.view.View
import com.vip.base.R

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
    var leftIconMarginLeft = 0//左边图片距离左边的距离

}