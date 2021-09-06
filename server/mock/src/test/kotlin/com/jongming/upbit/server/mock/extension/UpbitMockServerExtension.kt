package com.jongming.upbit.server.mock.extension

import com.jongming.upbit.server.mock.UpbitMockServer
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class UpbitMockServerExtension : BeforeAllCallback, AfterAllCallback {
    private val mockServer = UpbitMockServer()

    fun getPort() = mockServer.getPort()

    override fun beforeAll(context: ExtensionContext?) {
        mockServer.start()
    }

    override fun afterAll(context: ExtensionContext?) {
        mockServer.shutdown()
    }
}
