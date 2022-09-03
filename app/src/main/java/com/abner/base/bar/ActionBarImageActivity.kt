package com.abner.base.bar

import android.widget.Toast
import androidx.core.content.ContextCompat
import com.abner.base.R
import com.abner.base.databinding.ActivityActionBarImageBinding
import com.vip.base.activity.BaseActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:标题栏右侧图片按钮
 */
class ActionBarImageActivity :
    BaseActivity<ActivityActionBarImageBinding>(R.layout.activity_action_bar_image) {
    override fun initData() {
        setBarTitle("标题栏右侧图片按钮")

        //通过getRightMenu方法拿到右侧的TextView
        getActionBarView().apply {
            getRightMenu(
                ContextCompat.getDrawable(this@ActionBarImageActivity, R.mipmap.ic_launcher)!!
            ).setOnClickListener {
                Toast.makeText(this@ActionBarImageActivity, "右侧点击", Toast.LENGTH_SHORT).show()
            }

            //设置宽高和距离右边的距离
            setBarRightParams(20, 50, 50)
        }


    }

}