package com.abner.base.viewmodel

import android.widget.Toast
import com.abner.base.BR
import com.abner.base.R
import com.abner.base.databinding.ActivityViewModelBinding
import com.vip.base.activity.BaseVMActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:ViewModel方式使用
 */
class TestViewModelActivity : BaseVMActivity<ActivityViewModelBinding,
        TestViewModel>(R.layout.activity_view_model) {

    override fun initVMData() {
        setBarTitle("ViewModel方式使用")

        mBinding.btnLiveData.setOnClickListener {
            //liveData方式模拟
            mViewModel.doHttpLiveData()
        }

        mBinding.btnCallBack.setOnClickListener {
            //回调方式模拟
            mViewModel.doHttpCallback({
                //成功
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }, {
                //失败
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:重写observeLiveData方法，监听LiveData发生的改变
     */
    override fun observeLiveData() {
        super.observeLiveData()
        mViewModel.mResultLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun dialogLoading() {
        super.dialogLoading()
        //这里进行Loading加载
    }

    override fun dialogDismiss() {
        super.dialogDismiss()
        //这里进行Loading销毁
    }
}