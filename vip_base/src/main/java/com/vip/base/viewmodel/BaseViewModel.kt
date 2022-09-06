package com.vip.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vip.base.config.StateLayoutEnum
import com.vip.base.observer.BaseObserver

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/10
 *INTRODUCE:viewModel父类
 */
open class BaseViewModel : ViewModel(), BaseObserver {
    /**
     * 控制状态视图的LiveData
     */
    val mStateViewLiveData = MutableLiveData<StateLayoutEnum>()

    /**
     * 更改状态视图的状态
     */
    public fun changeStateView(
        state: StateLayoutEnum
    ) {
        // 对参数进行校验
        when (state) {
            StateLayoutEnum.DIALOG_LOADING -> {
                mStateViewLiveData.postValue(StateLayoutEnum.DIALOG_LOADING)
            }
            StateLayoutEnum.DIALOGD_DISMISS -> {
                mStateViewLiveData.postValue(StateLayoutEnum.DIALOGD_DISMISS)
            }
            StateLayoutEnum.DATA_ERROR -> {
                mStateViewLiveData.postValue(StateLayoutEnum.DATA_ERROR)
            }
            StateLayoutEnum.DATA_NULL -> {
                mStateViewLiveData.postValue(StateLayoutEnum.DATA_NULL)
            }
            StateLayoutEnum.NET_ERROR -> {
                mStateViewLiveData.postValue(StateLayoutEnum.NET_ERROR)
            }
            StateLayoutEnum.HIDE -> {
                mStateViewLiveData.postValue(StateLayoutEnum.HIDE)
            }
        }

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取Repository
     */
    inline fun <reified R> getRepository(): R? {
        try {
            val clazz = R::class.java
            return clazz.newInstance()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期初始化
     */
    override fun onCreate() {
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期页面可见
     */
    override fun onStart() {
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期页面获取焦点
     */
    override fun onResume() {
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期页面失去焦点
     */
    override fun onPause() {

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期页面不可见
     */
    override fun onStop() {
        
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:生命周期页面销毁
     */
    override fun onDestroy() {
    }
}