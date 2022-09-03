package com.vip.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/10
 *INTRODUCE:PagerAdapter父类
 */
class BasePagerAdapter(var viewList: ArrayList<View>, var titles: ArrayList<String>? = null) :
    PagerAdapter() {

    override fun getCount(): Int {
        return viewList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewList[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

}
