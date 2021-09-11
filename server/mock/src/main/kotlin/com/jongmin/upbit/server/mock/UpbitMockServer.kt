package com.jongmin.upbit.server.mock

import com.jongmin.upbit.server.mock.exchange.account.GetAccountsResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersChanceResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersResponse
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
                        /**
                         * Exchange API
                         */
                        // accounts
                        "/v1/accounts" -> return ok(GetAccountsResponse.fixture)
                        // orders
                        "/v1/orders/chance?market=market" -> return ok(GetOrdersChanceResponse.fixture)
                        "/v1/order?uuid=uuid" -> return ok(GetOrderResponse.fixture)
                        "/v1/orders?state=done&uuids=uuid" -> return ok(GetOrdersResponse.fixture)
                    }
                    return notFound()
                }
            }
        }
    }

    fun start() = server.start(0)
    fun shutdown() = server.shutdown()
    fun getUrl() = server.url("/")
    fun getAuthorizationToken() = server.takeRequest().getHeader("Authorization")
}

fun ok(body: String) = MockResponse().setResponseCode(200).setBody(body)
fun notFound() = MockResponse().setResponseCode(404)
