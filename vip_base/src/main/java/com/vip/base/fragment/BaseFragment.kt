package com.vip.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/9
 *INTRODUCE:Fragment父类
 */
abstract class BaseFragment<VB : ViewDataBinding>(@LayoutRes layoutId: Int = 0) :
    Fragment(layoutId) {

    lateinit var mBinding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DataBindingUtil.bind(view)!!
        initView()
        initData()
    }

    open fun initView() {}

    abstract fun initData()

}