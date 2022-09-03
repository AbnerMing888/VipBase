package com.vip.base.fragment

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.vip.base.config.StateLayoutEnum
import com.vip.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/10
 *INTRODUCE:使用ViewModel父类Fragment
 */
abstract class BaseVMFragment<VB : ViewDataBinding, BM : BaseViewModel>(@LayoutRes layoutId: Int = 0) :
    BaseFragment<VB>(layoutId) {
    lateinit var mViewModel: BM
    override fun initData() {
        mViewModel = getViewModel()!!
        initVMData()
        observeLiveData()
        initState()
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:初始化状态
     */
    private fun initState() {
        mViewModel.mStateViewLiveData.observe(this, {
            when (it) {
                StateLayoutEnum.DIALOG_LOADING -> {
                    dialogLoading()
                }
                StateLayoutEnum.DIALOGD_DISMISS -> {
                    dialogDismiss()
                }
                StateLayoutEnum.DATA_ERROR -> {
                    dataError()
                }
                StateLayoutEnum.DATA_NULL -> {
                    dataEmpty()
                }
                StateLayoutEnum.NET_ERROR -> {
                    netError()
                }
                StateLayoutEnum.HIDE -> {
                    hide()
                }
            }
        })
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:初始化数据
     */
    abstract fun initVMData()

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:LiveData的Observer
     */
    open fun observeLiveData() {

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:dialog加载
     */
    open fun dialogLoading() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:dialog隐藏
     */
    open fun dialogDismiss() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:数据错误
     */
    open fun dataError() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:数据为空
     */
    open fun dataEmpty() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:网络错误或请求错误
     */
    open fun netError() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:隐藏某些布局或者缺省页等
     */
    open fun hide() {}

    private fun getViewModel(): BM? {
        //这里获得到的是类的泛型的类型
        val type = javaClass.genericSuperclass
        if (type != null && type is ParameterizedType) {
            val actualTypeArguments = type.actualTypeArguments
            val tClass = actualTypeArguments[1]
            return ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
            )
                .get(tClass as Class<BM>)
        }
        return null
    }
}