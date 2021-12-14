package io.github.mzdluo123.miraispringbootstarter.test

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.FriendMessageEvent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller


@SpringBootApplication

class TestMain{

}


@Controller
class TestController: SimpleListenerHost() {
    @EventHandler
     suspend fun onFriendMessage(event: FriendMessageEvent){
        if ( event.message.contentToString() == "你好"){
            event.friend.sendMessage("你好呀")
        }
    }
}


fun main() {
    runApplication<TestMain>()
}
