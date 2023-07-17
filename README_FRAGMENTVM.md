# BaseVMFragment

BaseVMFragment继承于BaseFragment，适用于和ViewModel绑定的页面使用。

## 具体使用（案例）

1、新建xml布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout android:layout_width="match_parent"
        android:layout_height="match_parent">


    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

2、新建ViewModel页面

```kotlin

class HomeViewModel : BaseViewModel() {

}

```

3、新建Fragment页面

```kotlin

class HomeFragment : BaseVMFragment<FragmentHomeBinding,
        HomeViewModel>(R.layout.fragment_home) {

    override fun initVMData() {
        //初始化数据

    }
}

```

两种继承方式上，大部分方法都是通用的，在使用ViewModel的时候，有几个比较特殊的方法需要简单介绍一下。

监听ViewModel数据改变

需要重写observeLiveData方法。

```kotlin

override fun observeLiveData() {
    super.observeLiveData()

}

```

**获取绑定的xml variable。当xml和ViewModel绑定时，需要重写这个方法，传递BR**

```kotlin

override fun getVariableId(): Int {
    return super.getVariableId()
}

```

各种状态逻辑处理

主要包含dialog的加载和隐藏，数据的相关处理等，可以对以下在子类中进行重写。

```kotlin

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:dialog加载
 */
open fun dialogLoading() {}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:dialog隐藏
 */
open fun dialogDismiss() {}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:数据错误
 */
open fun dataError() {}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:数据为空
 */
open fun dataEmpty() {}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:网络错误或请求错误
 */
open fun netError() {}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:隐藏某些布局或者缺省页等
 */
open fun hide() {}

```

获取视图

xml中定义好id之后，直接使用mBinding加上对应控件的id即可，比如控件id为tv_name，获取如下：

```kotlin

mBinding.tvName

```

获取ViewModel

在继承BaseVMActivity的时候，需要调用ViewModel里的方法或属性，直接调用mViewModel即可。

```kotlin

mViewModel.doHttp()

```

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







