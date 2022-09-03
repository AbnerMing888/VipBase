package com.abner.base.status

import androidx.core.content.ContextCompat
import com.abner.base.R
import com.abner.base.databinding.ActivityStatusBarChangeBinding
import com.vip.base.activity.BaseActivity
import com.vip.base.util.darkMode
import com.vip.base.util.immersive
import com.vip.base.util.statusBarColor

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:状态栏改变
 */
class StatusBarChangeActivity :
    BaseActivity<ActivityStatusBarChangeBinding>(R.layout.activity_status_bar_change) {

    override fun initData() {
        /*
        * dark：文字颜色，true:黑色，false:白色
        * color:背景颜色
        * title:标题栏颜色
        * */
        setDarkTitle(false, R.color.purple_700, "状态栏改变")
        mBinding.btnChangeBlack.setOnClickListener {
            //黑色文字
            darkMode(true)
        }
        mBinding.btnChangeWhite.setOnClickListener {
            //白色文字
            darkMode(false)
        }
        mBinding.btnChangeBg.setOnClickListener {
            //改变状态栏背景
            statusBarColor(ContextCompat.getColor(this, R.color.base_color_7D828B))
        }

        mBinding.btnImmersive.setOnClickListener {
            /*
            * 透明状态栏
            * color:0,透明
            * darkMode：文字颜色，true:黑色，false:白色
            * */
            immersive(0, true)
        }
    }

}