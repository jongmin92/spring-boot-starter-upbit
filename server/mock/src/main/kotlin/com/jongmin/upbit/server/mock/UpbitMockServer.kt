package com.jongmin.upbit.server.mock

import com.jongmin.upbit.server.mock.exchange.getAccountsResponse
import okhttp3.Protocol
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

class UpbitMockServer {
    private val server = MockWebServer()

    init {
        server.apply {
            protocols = listOf(Protocol.H2_PRIOR_KNOWLEDGE)
            dispatcher = object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    when (request.path) {
                        "/v1/accounts" -> return ok(getAccountsResponse)
                    }
                    return notFound()
                }
            }
        }
    }

    fun start() = server.start(0)
    fun shutdown() = server.shutdown()
    fun getUrl() = server.url("/")
}

fun ok(body: String) = MockResponse().setResponseCode(200).setBody(body)
fun notFound() = MockResponse().setResponseCode(404)
