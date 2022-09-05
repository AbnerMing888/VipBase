# LiveDataBus

LiveDataBus是事件总线类，支持生命周期相关和无关的事件，支持粘性事件，具体使用方式如下：

### 发送普通事件

```kotlin

LiveDataBus.send("send", "我发送了一条普通消息")

```

普通事件回调监听


```kotlin
LiveDataBus.observe(this, "send", Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

```

### 发送粘性事件

```kotlin

LiveDataBus.sendSticky("sendSticky", "我发送了一条粘性事件消息")

```
粘性事件回调监听

```kotlin

 LiveDataBus.observeSticky(this, "sendSticky", Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

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







