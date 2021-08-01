package io.github.mzdluo123.miraispringbootstarter.config

import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.ListenerHost
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import org.springframework.core.type.filter.AnnotationTypeFilter

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.env.Environment
import org.springframework.core.type.filter.TypeFilter


@Configuration
class ListenerHostConfig(private val applicationContext: AnnotationConfigApplicationContext) {
    @PostConstruct
    fun init() {
        applicationContext.getBeansOfType(ListenerHost::class.java).forEach { (_, u) ->
            GlobalEventChannel.registerListenerHost(u)
        }
    }
}
