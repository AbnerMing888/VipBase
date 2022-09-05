# BaseFragment

具体使用（案例）

1、新建xml布局

```xml

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
  
  <data>
    
  </data>
  
  <androidx.constraintlayout.widget.ConstraintLayout
     android:layout_width="match_parent"
     android:layout_height="match_parent">
    
    
  </androidx.constraintlayout.widget.ConstraintLayout>
</layout>

```
2、新建Fragment页面

```kotlin

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun initData() {
        //初始化数据
      
    }
    
}

```

初始化View

无论是继承BaseActivity或者是BaseVMActivity，都会有一个必要要实现的初始化方法，因为考虑到实际的项目中采用基本上是DataBinding，很少再有初始化View的用法，当然父类当中也给提供了，大家重写initView方法即可。

```kotlin
/**
* AUTHOR:AbnerMing
* INTRODUCE:初始化视图
*/
override fun initView() {
    super.initView()
    
}
```

初始化数据

BaseFragment中

```kotlin

    override fun initData() {
        //初始化数据
    }

```

BaseVMFragment中

```kotlin
  override fun initVMData() {
        //初始化数据

    }

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







