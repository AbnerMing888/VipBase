# VipBase

VipBase是一个Android端基类融合库，目前抽取了Activity,Fragment，PagerAdapter等相关的父类，也提供了和父类相关的，沉浸式状态栏，统一的标题栏，事件消息分发总线等功能，无第三方依赖，都是Android原生的代码封装，请放心使用。

有了这个基类库，可以大大缩短的您的业务开发时间，可以统一所有的页面代码书写方式，让架构模式简单化，让业务代码清晰化，和目前主流的MVVM架构模式，完美契合，您只关心业务开发，其他的交给VipBase。

#### MVVM架构图

<img src="images/mvvm.jpg" width="400px" />

## VipBase快速使用

1、在你的跟项目下的build.gradle文件下，引入maven。

```groovy
allprojects {
    repositories {
        maven { url "https://gitee.com/AbnerAndroid/almighty/raw/master" }
    }
}
```
2、在你需要使用的Module中build.gradle文件下，引入依赖。

```groovy
dependencies {
    implementation 'com.vip:base:1.0.0'
}
```

## VipBase功能使用

|  相关功能  |  概述  |
|  ----  |  ----  |
|  BaseActivity  |  逻辑比较简单的Activity可以继承此类  |
|  BaseVMActivity  |  使用ViewModel的Activity可以继承此类  |
|  BaseFragment  |  逻辑比较简单的Fragment可以继承此类  |
|  BaseVMFragment  |  使用ViewModel的Fragment可以继承此类  |
|  BaseViewModel  |  ViewModel继承此类  |
|  FragmentPagerAdapter |  PagerAdapter父类结合TabLayout和ViewPager使用  |
|  StatusBar  |  状态栏工具类，可以实现沉浸式，透明等  |
|  ActionBarView  |  自定义的标题栏  |






