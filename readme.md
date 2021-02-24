# mirai-spring-boot-starter

# 开始使用

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