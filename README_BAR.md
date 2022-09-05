# ActionBarView

ActionBarView是一个自定义的标题栏View，由于在base库中已经给BaseActivity增加了，更改标题栏信息，只需要调用父类中的方法即可，无需再进行单独使用。

如果你的项目没有继承BaseActivity，想单独使用，可以按照下面的方式进行。

举例

xml视图中引入

```xml

<LinearLayout
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:orientation="vertical">

  <com.gwm.base.view.ActionBarView
    android:layout_width="match_parent"
    android:layout_height="@dimen/gwm_dp_50"
    app:bar_left_hint="true"
    app:bar_title="测试标题"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

  <com.gwm.base.view.ActionBarView
    android:id="@+id/action_bar"
    android:layout_width="match_parent"
    android:layout_height="@dimen/gwm_dp_50"
    app:bar_left_hint="true"
    app:bar_right_color="@color/base_color_ffffff"
    app:bar_right_text="右边"
    app:bar_title="测试标题带右边按钮" />

  <com.gwm.base.view.ActionBarView
    android:layout_width="match_parent"
    android:layout_height="@dimen/gwm_dp_50"
    app:bar_left_hint="true"
    app:bar_right_height="@dimen/gwm_dp_20"
    app:bar_right_icon="@mipmap/gwm_logo"
    app:bar_right_width="@dimen/gwm_dp_20"
    app:bar_title="测试标题带右边图片" />

</LinearLayout>

```

相关属性

|  属性  |  类型  |  说明  |
|  ----  |  ----  |  ----  |
|  bar_title	  |  string  |  标题  |
|  bar_title_size  |	dimension  |  标题大小  |
|  bar_title_color  |	color  |  标题颜色  |
|  bar_right_icon  |	reference  |  右边图片  |
|  bar_right_text  |	string  |  右边文字（文字和图片只能选择一个）  |
|  bar_right_color  |	color  |  右边文字颜色  |
|  bar_right_icon_margin  |  dimension  |  右边图片距离右边距离  |
|  bar_right_width  |	dimension  |  右边按钮宽度  |
|  bar_right_height  |	dimension  |  右边按钮高度  |
|  bar_left_icon  |  reference  |  左边图片  |
|  bar_left_width  |  dimension  |  左边图片宽度  |
|  bar_left_height  |  dimension  |  左边图片高度  |
|  bar_left_icon_margin  |  dimension  |  左边图片距离左边距离  |
|  bar_left_hint  |	boolean  |  是否隐藏左边按钮  |

除了属性相关，代码里也可以获取进行设置点击事件或者其他属性。


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







