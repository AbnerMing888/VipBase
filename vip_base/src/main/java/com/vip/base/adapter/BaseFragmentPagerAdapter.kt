@file:Suppress("FunctionName")

package com.vip.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/10
 *INTRODUCE:BaseFragmentPagerAdapter父类
 */
fun FragmentActivity.FragmentPagerAdapter(
    fragments: List<Fragment>,
    titles: List<String>? = null
): BaseFragmentPagerAdapter {
    return BaseFragmentPagerAdapter(supportFragmentManager, fragments, titles)
}

fun Fragment.FragmentPagerAdapter(
    fragments: List<Fragment>,
    titles: List<String>? = null
): BaseFragmentPagerAdapter {
    return BaseFragmentPagerAdapter(childFragmentManager, fragments, titles)
}


class BaseFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    var fragments: List<Fragment>,
    var titles: List<String>? = null
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

}

fun FragmentActivity.FragmentAdapter(
    fragments: List<Fragment>
): FragmentStateAdapter = object : FragmentStateAdapter(this) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}

fun Fragment.FragmentAdapter(
    fragments: List<Fragment>
): FragmentStateAdapter = object : FragmentStateAdapter(this) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}



