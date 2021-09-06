package com.jongming.upbit.server.mock

import com.jongming.upbit.server.mock.exchange.getAccountsResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

class UpbitMockServer {
    private val server = MockWebServer()

    init {
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                when (request.path) {
                    "/v1/accounts" -> return ok(getAccountsResponse)
                }
                return notFound()
            }
        }
    }

    fun start() = server.start()
    fun shutdown() = server.shutdown()
    fun getPort() = server.port
}

fun ok(body: String) = MockResponse().setResponseCode(200).setBody(body)
fun notFound() = MockResponse().setResponseCode(404)
