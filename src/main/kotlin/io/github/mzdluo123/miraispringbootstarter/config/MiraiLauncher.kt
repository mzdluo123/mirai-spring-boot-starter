package io.github.mzdluo123.miraispringbootstarter.config


import io.github.mzdluo123.miraispringbootstarter.properties.MiraiProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

private val scope = CoroutineScope(Job())

@Configuration
@Import(SpringBotFactory::class, ListenerHostConfig::class)
@EnableConfigurationProperties(MiraiProperties::class)
class MiraiLauncher : CommandLineRunner {

    override fun run(vararg args: String?) {
        Bot.instances.forEach {
            scope.launch { it.login() }
        }

        Thread.currentThread().join()
    }

}
