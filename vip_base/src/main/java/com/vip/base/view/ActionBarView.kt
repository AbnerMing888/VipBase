package com.vip.base.view

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.vip.base.R
import com.vip.base.config.BaseConfig
import com.vip.base.databinding.LayoutActionBarBinding

/**
 *AUTHOR:AbnerMing
 *DATE:2021/11/2
 *INTRODUCE:自定义title
 */
class ActionBarView : RelativeLayout {
    private var mBarRightTextColor: Int? = 0
    private var mBarLeftHint: Boolean? = false
    private var mBarRightText: String? = ""
    private var mBarLeftIconMargin: Float = 0f
    private var mBarLeftIcon: Drawable? = null
    private var mBarRightIconMargin: Float = 0f
    private var mBarRightIcon: Drawable? = null
    private var mBarTitleColor: Int = 0
    private var mBarTitleSize: Float = 0f
    private var mBarTitle: String? = ""
    private var mBind: LayoutActionBarBinding? = null
    private var mContext: Context? = null
    private var mBarLeftIconWidth: Float = 0f
    private var mBarLeftIconHeight: Float = 0f
    private var mBarRightIconWidth: Float = 0f
    private var mBarRightIconHeight: Float = 0f

    constructor(
        context: Context
    ) : super(context) {
        init(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        val ob =
            context.obtainStyledAttributes(attrs, R.styleable.ActionBarView)
        mBarLeftHint = ob.getBoolean(R.styleable.ActionBarView_bar_left_hint, false)
        mBarTitle = ob.getString(R.styleable.ActionBarView_bar_title)
        mBarRightText = ob.getString(R.styleable.ActionBarView_bar_right_text)
        mBarRightTextColor = ob.getColor(R.styleable.ActionBarView_bar_right_color, 0)
        mBarTitleSize = ob.getDimension(R.styleable.ActionBarView_bar_title_size, 0f)
        mBarTitleColor = ob.getColor(R.styleable.ActionBarView_bar_title_color, 0)
        mBarRightIcon = ob.getDrawable(R.styleable.ActionBarView_bar_right_icon)
        mBarRightIconMargin = ob.getDimension(R.styleable.ActionBarView_bar_right_icon_margin, 0f)
        mBarLeftIcon = ob.getDrawable(R.styleable.ActionBarView_bar_left_icon)
        mBarLeftIconMargin = ob.getDimension(R.styleable.ActionBarView_bar_left_icon_margin, 0f)

        mBarLeftIconWidth = ob.getDimension(R.styleable.ActionBarView_bar_left_width, 0f)
        mBarLeftIconHeight = ob.getDimension(R.styleable.ActionBarView_bar_left_height, 0f)
        mBarRightIconWidth = ob.getDimension(R.styleable.ActionBarView_bar_right_width, 0f)
        mBarRightIconHeight = ob.getDimension(R.styleable.ActionBarView_bar_right_height, 0f)
        init(context)
    }

    private fun init(context: Context) {
        mContext = context
        val view = View.inflate(context, R.layout.layout_action_bar, null)
        mBind = DataBindingUtil.bind(view)
        initData()
        addView(view)
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:初始化数据
     */
    private fun initData() {
        //设置ActionBar的高度
        if (BaseConfig.actionBarHeight != 0) {
            val parentParams = mBind!!.barLayout.layoutParams as LinearLayout.LayoutParams
            parentParams.height = BaseConfig.actionBarHeight
            mBind!!.barLayout.layoutParams = parentParams
        }
        //设置ActionBar的背景颜色
        if (BaseConfig.actionBarBg != 0) {
            mBind!!.barLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    BaseConfig.actionBarBg
                )
            )
        }

        mBind!!.barTvTitle.apply {
            //设置title
            if (!TextUtils.isEmpty(mBarTitle)) {
                text = mBarTitle
            }

            //设置title大小
            if (mBarTitleSize != 0f) {
                textSize = mBarTitleSize
            } else if (BaseConfig.titleSize != 0f) {
                //全局设置title文字大小
                textSize = BaseConfig.titleSize
            }
            //设置title颜色
            if (mBarTitleColor != 0) {
                setTextColor(mBarTitleColor)
            } else if (BaseConfig.titleColor != 0) {
                //全局设置title颜色
                //设置标题颜色
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        BaseConfig.titleColor
                    )
                )
            }
        }


        actionBarRight()


        //左侧按钮
        mBind!!.barIvBack.apply {
            //是否显示
            visibility = if (mBarLeftHint!!) {
                GONE
            } else {
                VISIBLE
            }
            //通过属性设置
            if (mBarLeftIcon != null) {
                //设置左侧图标
                setImageDrawable(mBarLeftIcon)
                //设置距离左侧的边距
                val params = layoutParams as LinearLayout.LayoutParams
                if (mBarLeftIconMargin != 0f) {
                    params.leftMargin = mBarLeftIconMargin.toInt()
                }
                //设置宽高
                if (mBarLeftIconWidth != 0f) {
                    params.width = mBarLeftIconWidth.toInt()
                    params.height = mBarLeftIconHeight.toInt()
                }
                layoutParams = params
                //设置左侧点击的事件
                mBind!!.barLayoutBack.setOnClickListener {
                    if (mOnLeftClickListener != null) {
                        mOnLeftClickListener!!.leftClick()
                    }
                }
            } else {

                if (BaseConfig.leftIcon != View.NO_ID) {
                    setBarLeftIcon(
                        BaseConfig.leftIcon,
                        BaseConfig.leftIconWidth,
                        BaseConfig.leftIconHeight,
                        BaseConfig.leftIconMarginLeft
                    )
                }
                mBind!!.barLayoutBack.setOnClickListener {
                    //返回，销毁页面
                    (mContext as Activity).finish()
                }
            }
        }

        //设置右边的颜色
        if (mBarRightTextColor != 0) {
            mBind!!.barTvRight.setTextColor(mBarRightTextColor!!)
        }

    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:actionBar右侧内容
     */
    private fun actionBarRight() {
        //内容不为空，显示右侧内容
        if (!TextUtils.isEmpty(mBarRightText)) {
            mBind!!.barTvRight.visibility = View.VISIBLE
            mBind!!.barTvRight.text = mBarRightText
        }

        //右侧设置图片格式
        if (mBarRightIcon != null) {
            mBind!!.barTvRight.visibility = View.VISIBLE
            mBind!!.barTvRight.background = mBarRightIcon

        }

        val layoutParams = mBind!!.barTvRight.layoutParams as RelativeLayout.LayoutParams
        //设置距离右边距离
        if (mBarRightIconMargin != 0f) {
            layoutParams.rightMargin = mBarRightIconMargin.toInt()
        }
        //设置宽
        if (mBarRightIconWidth != 0f) {
            layoutParams.width = mBarRightIconWidth.toInt()
        }
        //设置高
        if (mBarRightIconHeight != 0f) {
            layoutParams.height = mBarRightIconHeight.toInt()
        }
        mBind!!.barTvRight.layoutParams = layoutParams

        //右侧按钮点击事件
        mBind!!.barTvRight.setOnClickListener {
            if (mOnRightClickListener != null) {
                mOnRightClickListener!!.rightClick()
            }
        }
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置Title
     */
    fun setBarTitle(title: String) {
        mBind!!.barTvTitle.text = title
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置标题颜色
     */
    fun setBarTitleColor(color: Int) {
        mBind!!.barTvTitle.setTextColor(color)
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置标题大小
     */
    fun setBarTitleSize(size: Float) {
        mBind!!.barTvTitle.textSize = size
    }


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:只显示标题
     */
    fun hintLeftAndRight() {
        mBind!!.barLayoutBack.visibility = View.GONE
        mBind!!.barTvRight.visibility = View.GONE
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:显示右侧按钮
     */
    fun getRightMenu(menu: Any): TextView {
        if (menu is String) {
            mBarRightText = menu
        } else if (menu is Drawable) {
            mBarRightIcon = menu
        }
        actionBarRight()
        return mBind!!.barTvRight
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取title
     */
    fun getBarTitle(): TextView {
        return mBind!!.barTvTitle
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:左侧
     */
    fun getLeftMenu(): ImageView {
        return mBind!!.barIvBack
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置左边的图标及宽高距离左边的距离
     */
    fun setBarLeftIcon(icon: Int, l: Int = 0, w: Int = 0, h: Int = 0): ActionBarView {
        if (icon != View.NO_ID) {
            mBind!!.barIvBack.setImageResource(icon)
            if (l != 0) {
                val layoutParams = mBind!!.barIvBack.layoutParams as LinearLayout.LayoutParams
                layoutParams.apply {
                    width = w
                    height = h
                    leftMargin = l
                }
                mBind!!.barIvBack.layoutParams = layoutParams
            }
            mBind!!.barLayoutBack.setOnClickListener {
                if (mOnLeftClickListener != null) {
                    mOnLeftClickListener!!.leftClick()
                }
            }
        }
        return this
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:设置右边的宽高和距离
     */
    fun setBarRightParams(r: Int = 0, w: Int = 0, h: Int = 0): ActionBarView {
        if (r != 0) {
            val layoutParams = mBind!!.barTvRight.layoutParams as RelativeLayout.LayoutParams
            layoutParams.width = w
            layoutParams.height = h
            layoutParams.rightMargin = r
            mBind!!.barTvRight.layoutParams = layoutParams
        }
        return this
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:隐藏左边的按钮
     */
    fun hintLeftBack() {
        mBind!!.barLayoutBack.visibility = View.GONE
    }

    fun setOnRightClickListener(action: () -> Unit) {
        mOnRightClickListener = object : OnRightClickListener {
            override fun rightClick() {
                action()
            }

        }
    }

    private var mOnRightClickListener: OnRightClickListener? = null

    interface OnRightClickListener {
        fun rightClick()
    }

    private var mOnLeftClickListener: OnLeftClickListener? = null

    interface OnLeftClickListener {
        fun leftClick()
    }

    fun setOnLeftClickListener(action: () -> Unit) {
        mOnLeftClickListener = object : OnLeftClickListener {
            override fun leftClick() {
                action()
            }
        }
    }
}