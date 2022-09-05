package com.abner.base.bind

import com.abner.base.BR
import com.abner.base.R
import com.abner.base.databinding.ActivityDataBindBinding
import com.vip.base.activity.BaseVMActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/3
 *INTRODUCE:DataBind
 */
class DataBindActivity :
    BaseVMActivity<ActivityDataBindBinding,
            DataBindViewModel>(R.layout.activity_data_bind) {

    override fun initVMData() {
        setBarTitle("DataBinding使用")
    }

    override fun getVariableId(): Int {
        return BR.data
    }
}