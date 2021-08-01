package io.github.mzdluo123.miraispringbootstarter.config

import io.github.mzdluo123.miraispringbootstarter.properties.MiraiProperties
import kotlinx.coroutines.*
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.utils.BotConfiguration
import okhttp3.internal.wait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import kotlin.coroutines.CoroutineContext
import kotlin.system.exitProcess

@Component
class SpringBotFactory : CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Default

    @Autowired
    lateinit var config: MiraiProperties

    @Bean
    fun init(): Bot {
        val botConfig = BotConfiguration {
            protocol = BotConfiguration.MiraiProtocol.valueOf(config.protocol)
            fileBasedDeviceInfo(config.deviceConfig)
            if (!config.enableNetLog) {
                this.noNetworkLog()
            } else {
                this.networkLoggerSupplier = { SpringBotLogger("mirai.bot.${config.uid}") }
            }
            this.botLoggerSupplier = { SpringBotLogger("mirai.bot.network.${config.uid}") }

        }
        val bot = BotFactory.newBot(config.uid, config.password, botConfig)
        launch { exit(bot) }
        return bot
    }

    suspend fun exit(bot:Bot) {
        while (bot.isActive){
            bot.join()
        }
        exitProcess(-1)
    }
}
