package com.abner.base.bar

import android.widget.Toast
import androidx.core.content.ContextCompat
import com.abner.base.R
import com.abner.base.databinding.ActivityActionBarTextBinding
import com.vip.base.activity.BaseActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:标题栏右侧文字按钮
 */
class ActionBarTextActivity :
    BaseActivity<ActivityActionBarTextBinding>(R.layout.activity_action_bar_text) {

    override fun initData() {
        setBarTitle("标题栏右侧文字按钮")

        //通过getRightMenu方法拿到右侧的TextView，控件都拿到的，颜色，大小，事件等等，你可以为所欲为！
        getActionBarView()
            .getRightMenu("右侧").apply {
                //设置颜色
                setTextColor(
                    ContextCompat.getColor(
                        this@ActionBarTextActivity,
                        R.color.base_color_ffffff
                    )
                )
                //设置点击事件
                setOnClickListener {
                    Toast.makeText(this@ActionBarTextActivity, "右侧点击", Toast.LENGTH_SHORT).show()
                }
            }

    }

}