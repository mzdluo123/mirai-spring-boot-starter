package io.github.mzdluo123.miraispringbootstarter.config

import io.github.mzdluo123.miraispringbootstarter.properties.MiraiProperties
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class SpringBotFactory {
    @Autowired
    lateinit var config: MiraiProperties

    @Bean
    fun init(): Bot {

        val botConfig = BotConfiguration {
            fileBasedDeviceInfo(config.deviceConfig)
            if (!config.enableNetLog) {
                this.noNetworkLog()
            } else {
                this.networkLoggerSupplier = { SpringBotLogger("BOT-NET ${config.uid}") }
            }
            this.botLoggerSupplier = { SpringBotLogger("BOT ${config.uid}") }

        }
        return BotFactory.newBot(config.uid, config.password, botConfig)
    }

}