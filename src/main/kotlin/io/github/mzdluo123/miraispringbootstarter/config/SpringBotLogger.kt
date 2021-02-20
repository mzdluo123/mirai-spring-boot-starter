package io.github.mzdluo123.miraispringbootstarter.config

import net.mamoe.mirai.utils.MiraiLoggerPlatformBase
import org.slf4j.LoggerFactory


class SpringBotLogger(override val identity: String?) : MiraiLoggerPlatformBase() {
    private val logger = LoggerFactory.getLogger(identity)
    override fun debug0(message: String?, e: Throwable?) {
        logger.debug(message, e)
    }

    override fun error0(message: String?, e: Throwable?) {
        logger.error(message, e)
    }

    override fun info0(message: String?, e: Throwable?) {
        logger.info(message, e)
    }

    override fun verbose0(message: String?, e: Throwable?) {
        logger.trace(message, e)
    }

    override fun warning0(message: String?, e: Throwable?) {
        logger.warn(message, e)
    }
}