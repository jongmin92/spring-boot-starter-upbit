package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongming.upbit.server.mock.extension.UpbitMockServerJunit
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.test.annotation.DirtiesContext

@DirtiesContext
abstract class UpbitLocalMockServer {

    companion object {
        @JvmField
        @RegisterExtension
        val upbitMockServer = UpbitMockServerJunit.extension()

        @JvmStatic
        @BeforeAll
        fun setUp() {
            System.setProperty("upbit.client.api-base-url", "${upbitMockServer.getUrl()}")
        }
    }
}
