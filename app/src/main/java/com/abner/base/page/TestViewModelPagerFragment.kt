package com.abner.base.page

import com.abner.base.R
import com.abner.base.databinding.FragmentTestPagerBinding
import com.vip.base.fragment.BaseVMFragment

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:测试Fragment,ViewModel继承
 */
class TestViewModelPagerFragment :
    BaseVMFragment<FragmentTestPagerBinding,
            TestFragmentViewModel>(R.layout.fragment_test_pager) {


    override fun initVMData() {
        mBinding.tvContent.text = "我是ViewModel形式的继承案例"
    }

}