package io.github.mzdluo123.miraispringbootstarter.config

import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.ListenerHost
import org.apache.commons.logging.LogFactory
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import org.springframework.core.type.filter.AnnotationTypeFilter

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.env.Environment
import org.springframework.core.type.filter.TypeFilter
import kotlin.math.log
import kotlin.system.exitProcess


@Configuration
class ListenerHostConfig(private val applicationContext: AnnotationConfigApplicationContext) {
    private val logger = LogFactory.getLog(MiraiLauncher::class.java)
    @PostConstruct
    fun init() {
        try {
            applicationContext.getBeansOfType(ListenerHost::class.java).forEach { (_, u) ->
                GlobalEventChannel.registerListenerHost(u)
            }
        }catch (e:Exception){
            logger.error("注册事件监听器时出现错误",e)
            exitProcess(-1)
        }
    }
}
