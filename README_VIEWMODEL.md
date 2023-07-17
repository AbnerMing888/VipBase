# BaseViewModel

base的库中，ViewModel并未有过多的复杂逻辑，在实际的聚合层中，可以继承BaseViewModel，进行拓展一些实际的需求，比如访问网络的，数据处理相关的，在正常的需求开发中，需要注意，如果用到了ViewModel，一定要继承于BaseViewModel或它的子类。

具体使用

1、创建viewModel页面

```kotlin

class HomeViewModel : BaseViewModel() {

}

```

2、结合Activity使用

```kotlin

class HomeActivity : BaseVMActivity<ActivityHomeBinding,
        HomeViewModel>(R.layout.activity_home) {

    override fun initVMData() {
        //初始化数据

    }

}
```

3、结合Fragment使用

```kotlin

class HomeFragment : BaseVMFragment<FragmentHomeBinding,
        HomeViewModel>(R.layout.fragment_home) {

    override fun initVMData() {
        //初始化数据

    }

}

```

4、viewModel里状态改变

目前base库中给出了如下的状态属性，通过枚举值进行区分。

枚举类

```kotlin

enum class StateLayoutEnum {
    DIALOG_LOADING,    // dialog加载中
    DIALOGD_DISMISS,//dialog隐藏
    DATA_ERROR,      // 数据错误
    DATA_NULL,    // 没有数据
    NET_ERROR,//网络错误
    HIDE,       // 隐藏
}

```

改变状态

viewModel中的状态改变，可以直接调用changeStateView方法。

```kotlin

changeStateView(StateLayoutEnum.DIALOG_LOADING)


```

5、Repository获取

Repository可以进行复用，只需要在相应的ViewModel里获取不同的Repository即可。

```kotlin

val repository = getRepository<MainRepository>()

```

6、生命周期方法，可以在子类中重写

```kotlin

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期初始化
 */
override fun onCreate() {
}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期页面可见
 */
override fun onStart() {
}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期页面获取焦点
 */
override fun onResume() {
}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期页面失去焦点
 */
override fun onPause() {

}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期页面不可见
 */
override fun onStop() {

}

/**
 * AUTHOR:AbnerMing
 * INTRODUCE:生命周期页面销毁
 */
override fun onDestroy() {
}

```

7、如何调用ViewModel的方法或属性

在对应的Activity里或Fragment里如下调用，doHttp是定义在ViewModel里的方法。

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







