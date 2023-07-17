# PagerAdapter

主要方便TabLayout和ViewPager进行结合使用

### 具体使用(案例)

代码

xml布局

```xml

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.google.android.material.tabs.TabLayout android:id="@+id/tab_layout"
            android:layout_width="match_parent" android:layout_height="@dimen/gwm_dp_50"
            app:tabMode="scrollable" app:layout_constraintTop_toTopOf="parent" />

        <androidx.viewpager.widget.ViewPager android:id="@+id/vp_view"
            android:layout_width="match_parent" android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintTop_toBottomOf="@id/tab_layout" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>

```

绑定ViewPager

activity或者fragment里进行设置

```kotlin
//Fragment集合
private val mPageList = arrayListOf<Fragment>(
    FlowFragment(),
    ShapeFragment(),
    SearchFragment(),
    ActionBarFragment(),
    KeyboardFragment()
)
//标题集合 和Fragment保持一致
private val mPageTitle = arrayListOf("流式布局", "Shape背景", "自定义搜索框", "标题栏", "数字键盘")
override fun initData() {
    val fragmentPagerAdapter = FragmentPagerAdapter(mPageList, mPageTitle)
    mBinding.vpView.adapter = fragmentPagerAdapter
    mBinding.tabLayout.setupWithViewPager(mBinding.vpView)
}

```

效果

<img src="images/activity_vp.jpg" width="200px" />

## License

```
Copyright (C) AbnerMing, VipBase Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```







