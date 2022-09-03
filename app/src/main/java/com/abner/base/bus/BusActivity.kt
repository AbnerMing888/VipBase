package com.abner.base.bus

import android.widget.Toast
import androidx.lifecycle.Observer
import com.abner.base.R
import com.abner.base.databinding.ActivityBusBinding
import com.vip.base.activity.BaseActivity
import com.vip.base.bus.LiveDataBus

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/3
 *INTRODUCE:事件总线，消息通知
 */
class BusActivity : BaseActivity<ActivityBusBinding>(R.layout.activity_bus) {

    override fun initData() {

        setBarTitle("事件消息总线")

        mBinding.btnSend.setOnClickListener {
            //发送普通事件
            LiveDataBus.send("send", "我发送了一条普通消息")
        }

        mBinding.btnSendSticky.setOnClickListener {
            //发送粘性事件
            LiveDataBus.sendSticky("sendSticky", "我发送了一条粘性事件消息")
        }

        LiveDataBus.observe(this, "send", Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        LiveDataBus.observeSticky(this, "sendSticky", Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }
}