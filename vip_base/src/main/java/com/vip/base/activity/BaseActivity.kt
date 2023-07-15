package com.vip.base.activity

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.vip.base.R
import com.vip.base.bus.LiveDataBus
import com.vip.base.config.BaseConfig
import com.vip.base.util.darkMode
import com.vip.base.util.immersive
import com.vip.base.util.statusBarColor
import com.vip.base.util.statusBarHeight
import com.vip.base.view.ActionBarView

/**
 *AUTHOR:AbnerMing
 *DATE:2022/8/9
 *INTRODUCE:Activity父类
 */
abstract class BaseActivity<VB : ViewDataBinding>(@LayoutRes layoutId: Int = 0) :
    AppCompatActivity() {

    private var mActionBarView: ActionBarView? = null
    private var mLayoutError: FrameLayout? = null
    private var mLayoutId = layoutId
    lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //默认状态栏为白底黑字
        darkMode(BaseConfig.statusBarDarkMode)
        statusBarColor(ContextCompat.getColor(this, BaseConfig.statusBarColor))
        setContentView(R.layout.activity_base)
        val baseChild = findViewById<FrameLayout>(R.id.layout_base_child)
        mLayoutError = findViewById(R.id.layout_empty_or_error)
        mActionBarView = findViewById(R.id.action_bar)

        if (mLayoutId == 0) {
            mLayoutId = getLayoutId()
        }

        if (savedInstanceState != null && getIntercept()) {
            noEmptyBundle()
            return
        }

        val childView = layoutInflater.inflate(mLayoutId, null)
        baseChild.addView(childView)
        mBinding = DataBindingUtil.bind(childView)!!

        BaseConfig.getActivityListener()?.onCreate(savedInstanceState, this)

        initView()
        initData()

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取视图id
     */
    open fun getLayoutId(): Int {
        return 0
    }

    open fun initView() {}

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:初始化数据
     */
    abstract fun initData()


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:动态改变状态栏颜色和标题
     */
    fun setDarkTitle(dark: Boolean, color: Int, title: String) {
        try {
            darkMode(dark)
            statusBarColor(ContextCompat.getColor(this, color))
            setBarTitle(title)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置标题
     */
    fun setBarTitle(title: String) {
        mActionBarView!!.visibility = View.VISIBLE
        mActionBarView!!.setBarTitle(title)
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:隐藏左侧按钮
     */

    fun hintLeftMenu() {
        mActionBarView!!.hintLeftBack()
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取ActionBarView
     */
    fun getActionBarView(): ActionBarView {
        return mActionBarView!!
    }

    fun hintActionBar() {
        getActionBarView().visibility = View.GONE
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:Bundle为空进行拦截，解决改变权限后重回App崩溃问题
     */
    open fun getIntercept(): Boolean {
        return false
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:Bundle为空时的逻辑处理，解决改变权限后重回App崩溃问题
     */
    open fun noEmptyBundle() {}


    override fun onDestroy() {
        super.onDestroy()
        try {
            BaseConfig.getActivityListener()?.onDestroy()
            LiveDataBus.removeObserve(this)
            LiveDataBus.removeStickyObserver(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:透明状态栏
     */
    fun translucentWindow(dark: Boolean, isTop: Boolean = false) {
        try {
            immersive(0, dark)
            if (isTop) {
                val layoutParams = mActionBarView?.layoutParams as LinearLayout.LayoutParams
                layoutParams.topMargin = statusBarHeight
                mActionBarView?.layoutParams = layoutParams
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置缺省页
     */
    fun setEmptyOrError(view: View) {
        mLayoutError?.visibility = View.VISIBLE
        mLayoutError?.removeAllViews()
        mLayoutError?.addView(view)
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:隐藏
     */
    fun hintEmptyOrErrorView() {
        mLayoutError?.visibility = View.GONE
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取错误或为空的view
     */
    fun getEmptyOrErrorView(): FrameLayout {
        return mLayoutError!!
    }

    override fun onStart() {
        super.onStart()
        BaseConfig.getActivityListener()?.onStart()
    }

    override fun onRestart() {
        super.onRestart()
        BaseConfig.getActivityListener()?.onRestart()
    }

    override fun onPause() {
        super.onPause()
        BaseConfig.getActivityListener()?.onPause()
    }

    override fun onStop() {
        super.onStop()
        BaseConfig.getActivityListener()?.onStop()
    }

}