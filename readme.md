# mirai-spring-boot-starter

一个简单的springboot starter，可让你在springboot生态中使用mirai开发机器人

# 开始使用

```
repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
    
dependencies {
	        implementation 'com.github.mzdluo123:mirai-spring-boot-starter:版本号'
	}
```
最新版本号：[![](https://jitpack.io/v/mzdluo123/mirai-spring-boot-starter.svg)](https://jitpack.io/#mzdluo123/mirai-spring-boot-starter)

添加以下配置

```
mirai.uid= qq号
mirai.password= 密码
```

程序启动后将自动完成登录

# 编写代码

```kotlin
@Controller
class TestController: SimpleListenerHost() {

    @Autowired
    lateinit var bot:Bot

    @EventHandler
    suspend fun onGroupMessage(event:GroupMessageEvent){
        // 编写你的代码吧
    }
}
```
