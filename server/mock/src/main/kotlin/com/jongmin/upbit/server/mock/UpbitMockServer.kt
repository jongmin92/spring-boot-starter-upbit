package com.jongmin.upbit.server.mock

import com.jongmin.upbit.server.mock.exchange.account.GetAccountsResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsCoinAddressResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsCoinAddressesResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsResponse
import com.jongmin.upbit.server.mock.exchange.deposit.PostDepositsGenerateCoinAddressResponse1
import com.jongmin.upbit.server.mock.exchange.order.DeleteOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersChanceResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersResponse
import com.jongmin.upbit.server.mock.exchange.order.PostOrdersResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawsChanceResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawsResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.PostWithdrawsCoinResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.PostWithdrawsKrwResponse
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
                        "/v1/order?uuid=uuid" -> when (request.method!!) {
                            "GET" -> return ok(GetOrderResponse.fixture)
                            "DELETE" -> return ok(DeleteOrderResponse.fixture)
                        }
                        "/v1/orders" -> return ok(PostOrdersResponse.fixture)
                        "/v1/orders/chance?market=market" -> return ok(GetOrdersChanceResponse.fixture)
                        "/v1/orders?state=done&uuids=uuid" -> return ok(GetOrdersResponse.fixture)
                        // withdraws
                        "/v1/withdraw?uuid=uuid" -> return ok(GetWithdrawResponse.fixture)
                        "/v1/withdraws?currency=currency&txids=txid" -> return ok(GetWithdrawsResponse.fixture)
                        "/v1/withdraws/chance?currency=currency" -> return ok(GetWithdrawsChanceResponse.fixture)
                        "/v1/withdraws/coin" -> return ok(PostWithdrawsCoinResponse.fixture)
                        "/v1/withdraws/krw" -> return ok(PostWithdrawsKrwResponse.fixture)
                        // deposits
                        "/v1/deposit?uuid=uuid" -> return ok(GetDepositResponse.fixture)
                        "/v1/deposits?currency=currency&txids=txid" -> return ok(GetDepositsResponse.fixture)
                        "/v1/deposits/generate_coin_address" -> return ok(PostDepositsGenerateCoinAddressResponse1.fixture)
                        "/v1/deposits/coin_addresses" -> return ok(GetDepositsCoinAddressesResponse.fixture)
                        "/v1/deposits/coin_address?currency=currency" -> return ok(GetDepositsCoinAddressResponse.fixture)
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

private fun ok(body: String) = MockResponse().setResponseCode(200).setBody(body)
private fun notFound() = MockResponse().setResponseCode(404)
