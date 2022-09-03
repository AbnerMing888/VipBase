package com.abner.base.repository

import androidx.lifecycle.MutableLiveData
import com.vip.base.viewmodel.BaseViewModel

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:Repository模拟使用之ViewModel
 */
class TestRepositoryViewModel : BaseViewModel() {

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取需要的Repository
     */
    private val repository by lazy {
        getRepository<TestRepository>()
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取LiveData
     */
    fun getLiveData(): MutableLiveData<String>? {
        return repository?.mResultLiveData
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:LiveData进行返回数据,模拟网络请求
     */
    fun doHttpLiveData() {
        repository?.doHttpLiveData()
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:模拟数据请求，真实情况，请以实际业务为主
     */
    fun doHttpCallback(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        repository?.doHttpCallback({
            success.invoke(it)
        }, {
            error.invoke(it)
        })
    }
}