package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongming.upbit.server.mock.extension.UpbitMockServerJunit
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.RegisterExtension

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
