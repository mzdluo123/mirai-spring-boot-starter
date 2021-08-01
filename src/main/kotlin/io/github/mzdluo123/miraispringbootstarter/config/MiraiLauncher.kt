package io.github.mzdluo123.miraispringbootstarter.config


import io.github.mzdluo123.miraispringbootstarter.properties.MiraiProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import org.apache.commons.logging.LogFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import kotlin.system.exitProcess

private val scope = CoroutineScope(Job())

@Configuration
@Import(SpringBotFactory::class, ListenerHostConfig::class)
@EnableConfigurationProperties(MiraiProperties::class)
class MiraiLauncher : CommandLineRunner {
    private val logger = LogFactory.getLog(MiraiLauncher::class.java)

    override fun run(vararg args: String?) {
        try {
            Bot.instances.forEach {
                scope.launch { it.login() }
            }
        }catch (e:Exception){
            logger.error("加载Mirai出现错误",e)
            exitProcess(-1)
        }

        Thread.currentThread().join()
    }

}
