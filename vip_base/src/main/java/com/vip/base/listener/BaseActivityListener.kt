package com.vip.base.listener

import android.content.Context
import android.os.Bundle

/**
 *AUTHOR:AbnerMing
 *DATE:2023/2/8
 *INTRODUCE:BaseActivity监听
 */
interface BaseActivityListener {

    fun onCreate(savedInstanceState: Bundle?,context: Context)

    fun onStart()

    fun onRestart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}