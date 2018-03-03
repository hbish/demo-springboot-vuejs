package com.hbish.backend

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class HelloController {

    private val LOG = LoggerFactory.getLogger(HelloController::class.java)

    val counter = AtomicLong()

    @GetMapping("api/hello")
    fun hello (): String {
        LOG.info("GET called on /hello resource")
        return "hello ${counter.getAndIncrement()}"
    }

}