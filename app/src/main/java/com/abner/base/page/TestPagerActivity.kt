package com.abner.base.page

import androidx.viewpager.widget.ViewPager
import com.abner.base.R
import com.abner.base.databinding.ActivityTestPagerBinding
import com.vip.base.activity.BaseActivity
import com.vip.base.adapter.FragmentPagerAdapter

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/1
 *INTRODUCE:BaseFragmentPagerAdapter使用
 */
class TestPagerActivity : BaseActivity<ActivityTestPagerBinding>(R.layout.activity_test_pager) {

    private val mTitles = arrayListOf("测试条目一", "测试条目二", "测试条目三", "测试条目四")
    private val mFragmens = arrayListOf(
        TestPagerFragment(),
        TestPagerFragment(),
        TestPagerFragment(),
        TestViewModelPagerFragment()//Fragment,ViewModel继承，看这里
    )

    override fun initData() {
        setBarTitle("PagerAdapter使用")

        val fragmentPagerAdapter = FragmentPagerAdapter(mFragmens, mTitles)
        mBinding.viewPager.adapter = fragmentPagerAdapter
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)

        mBinding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                val testPagerFragment = mFragmens[position]
                if (testPagerFragment is TestPagerFragment) {
                    testPagerFragment.changeText(mTitles[position])
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

}