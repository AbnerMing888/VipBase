package com.abner.base.repository

import android.widget.Toast
import com.abner.base.R
import com.abner.base.databinding.ActivityRepositoryBinding
import com.vip.base.activity.BaseVMActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:Repository模拟使用，和单ViewModel使用区别是，把数据请求放到Repository里，可以实现数据
 * 请求复用
 */
class TestRepositoryActivity : BaseVMActivity<ActivityRepositoryBinding,
        TestRepositoryViewModel>(R.layout.activity_repository) {

    override fun initVMData() {
        setBarTitle("结合Repository使用")

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
        mViewModel.getLiveData()?.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}