package com.abner.base.bind

import android.view.View
import android.widget.Toast
import com.vip.base.viewmodel.BaseViewModel

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/3
 *INTRODUCE:
 */
class DataBindViewModel : BaseViewModel() {

    var oneWayContent = "单向绑定数据测试"

    var twoWayContent = "双向绑定数据测试"

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取双向绑定数据
     */
    var clickListener = View.OnClickListener {

        Toast.makeText(it.context, twoWayContent, Toast.LENGTH_SHORT).show()
    }
}