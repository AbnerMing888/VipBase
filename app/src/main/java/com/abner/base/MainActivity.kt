package com.abner.base

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.abner.base.bar.ActionBarImageActivity
import com.abner.base.bar.ActionBarTextActivity
import com.abner.base.bind.DataBindActivity
import com.abner.base.bus.BusActivity
import com.abner.base.databinding.ActivityMainBinding
import com.abner.base.page.TestPagerActivity
import com.abner.base.repository.TestRepositoryActivity
import com.abner.base.status.StatusBarActivity
import com.abner.base.status.StatusBarChangeActivity
import com.abner.base.viewmodel.TestViewModelActivity
import com.vip.base.activity.BaseActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:主页
 */
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:初始化数据
     */
    override fun initData() {
        setBarTitle("主页")
        hintLeftMenu()

        mBinding.btnActivity.setOnClickListener {
            //ViewModel使用跳转
            Toast.makeText(
                this, "查看MainActivity即可",
                Toast.LENGTH_SHORT
            ).show()
        }

        mBinding.btnViewModel.setOnClickListener {
            //ViewModel使用跳转
            start<TestViewModelActivity>()
        }

        mBinding.btnRepository.setOnClickListener {
            //Repository使用
            start<TestRepositoryActivity>()
        }

        mBinding.btnDataBind.setOnClickListener {
            //Repository使用
            start<DataBindActivity>()
        }

        mBinding.btnActionBarText.setOnClickListener {
            //标题栏左侧文字按钮
            start<ActionBarTextActivity>()
        }

        mBinding.btnActionBarImage.setOnClickListener {
            //标题栏左侧图片按钮
            start<ActionBarImageActivity>()
        }

        mBinding.btnStatusBar.setOnClickListener {
            //透明状态栏
            start<StatusBarActivity>()
        }
        mBinding.btnStatusBarChange.setOnClickListener {
            //状态栏改变
            start<StatusBarChangeActivity>()
        }

        mBinding.btnPager.setOnClickListener {
            //BaseFragmentPagerAdapter使用
            start<TestPagerActivity>()
        }

        mBinding.btnFragment.setOnClickListener {
            //Fragment简单继承
            start<TestPagerActivity>()
        }

        mBinding.btnFragmentViewModel.setOnClickListener {
            //Fragment  ViewModel 形式继承 打开后直接看 TestViewModelPagerFragment
            start<TestPagerActivity>()
        }

        mBinding.btnBus.setOnClickListener {
            //事件总线
            start<BusActivity>()
        }
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:跳转
     */
    private inline fun <reified activity : Activity> start() {
        startActivity(Intent(this, activity::class.java))
    }
}