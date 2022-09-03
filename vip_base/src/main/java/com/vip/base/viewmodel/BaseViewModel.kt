package com.vip.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vip.base.config.StateLayoutEnum

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/10
 *INTRODUCE:viewModel父类
 */
open class BaseViewModel : ViewModel() {
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

}