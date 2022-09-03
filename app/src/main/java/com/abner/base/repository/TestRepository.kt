package com.abner.base.repository

import androidx.lifecycle.MutableLiveData

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:测试Repository,执行数据请求
 */
class TestRepository {

    //LiveData方式返回数据，类型自定义，对象，集合或者其他类型，请以实际业务为准
    val mResultLiveData = MutableLiveData<String>()

    //测试用，用来判断是成功还是失败，真实请以请求接口为准
    private var mIsSuccess = true


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:LiveData进行返回数据，模拟网络请求
     */
    fun doHttpLiveData() {
        //当前为测试，实际返回数据及类型，成功和失败，请以真实为主
        if (mIsSuccess) {
            mResultLiveData.postValue("我是LiveData方式模拟数据")
        } else {
            mResultLiveData.postValue("网络请求失败")
        }

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:模拟数据请求，真实情况请以业务需求为主
     */
    fun doHttpCallback(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        if (mIsSuccess) {
            success.invoke("我是回调方式模拟数据")
        } else {
            error.invoke("我是回调方式的网络请求失败")
        }

    }
}