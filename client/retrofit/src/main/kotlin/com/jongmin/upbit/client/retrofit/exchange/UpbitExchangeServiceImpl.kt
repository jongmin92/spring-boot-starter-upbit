package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomainException
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.exchange.account.UpbitAccount
import com.jongmin.upbit.exchange.deposit.UpbitCreateDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitCreatedDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDeposit
import com.jongmin.upbit.exchange.deposit.UpbitDepositKrw
import com.jongmin.upbit.exchange.deposit.UpbitDeposits
import com.jongmin.upbit.exchange.deposit.UpbitDepositsCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDepositsCoinAddresses
import com.jongmin.upbit.exchange.info.UpbitApiKeys
import com.jongmin.upbit.exchange.info.UpbitWalletStatus
import com.jongmin.upbit.exchange.order.UpbitOrder
import com.jongmin.upbit.exchange.order.UpbitOrderDelete
import com.jongmin.upbit.exchange.order.UpbitOrderIncludingTrades
import com.jongmin.upbit.exchange.order.UpbitOrderPost
import com.jongmin.upbit.exchange.order.UpbitOrdersChance
import com.jongmin.upbit.exchange.withdraw.UpbitWithdraw
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawCoinPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawKrwPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsChance
import com.jongmin.upbit.token.AuthorizationTokenService
import com.linecorp.armeria.client.Clients
import retrofit2.Call

class UpbitExchangeServiceImpl(
    private val upbitExchangeApi: UpbitExchangeApi,
    private val authorizationTokenService: AuthorizationTokenService
) : UpbitExchangeService {
    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }

    private val objectMapper = jacksonObjectMapper().apply {
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun <T> apiExecute(api: () -> Call<T>): T {
        val response = api().execute()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw objectMapper.readValue(response.errorBody()!!.bytes(), ApiErrorResponse::class.java)
                .toDomainException(null)
        }
    }

    override fun getAccounts(): List<UpbitAccount> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { upbitExchangeApi.getAccounts() }.map { it.toDomain() }
        }
    }

    override fun getOrdersChance(market: String): UpbitOrdersChance {
        val params = mapOf<String, Any>("market" to market)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getOrdersChance(market) }.toDomain()
        }
    }

    override fun getOrder(uuid: String?, identifier: String?): UpbitOrderIncludingTrades {
        val params = mutableMapOf<String, Any>()
        uuid?.let { params.put("uuid", it) }
        identifier?.let { params.put("identifier", it) }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getOrder(uuid, identifier) }.toDomain()
        }
    }

    override fun getOrders(
        market: String,
        state: String,
        states: List<String>,
        uuids: List<String>,
        identifiers: List<String>,
        page: Int,
        limit: Int,
        orderBy: String
    ): List<UpbitOrder> {
        val params = mapOf<String, Any>("state" to state, "uuids" to uuids)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.getOrders(
                    market = market,
                    state = state,
                    states = states,
                    uuids = uuids,
                    identifier = identifiers,
                    page = page,
                    limit = limit,
                    orderBy = orderBy
                )
            }.map { it.toDomain() }
        }
    }

    override fun deleteOrder(uuid: String?, identifier: String?): UpbitOrderDelete {
        val params = mutableMapOf<String, Any>()
        uuid?.let { params.put("uuid", it) }
        identifier?.let { params.put("identifier", it) }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.deleteOrder(uuid, identifier) }.toDomain()
        }
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): UpbitOrderPost {
        val params = mapOf<String, Any>(
            "market" to market,
            "side" to side,
            "volume" to volume,
            "price" to price,
            "ord_type" to ordType
        )
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.postOrders(
                    UpbitOrderPostRequest(
                        market,
                        side,
                        volume,
                        price,
                        ordType,
                        identifier
                    )
                )
            }.toDomain()
        }
    }

    override fun getWithdraws(
        currency: String,
        state: String,
        uuids: List<String>,
        txids: List<String>,
        limit: Int,
        page: Int,
        orderBy: String
    ): List<UpbitWithdraw> {
        val params = mapOf("currency" to currency, "txids" to txids)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.getWithdraws(
                    currency,
                    state,
                    uuids,
                    txids,
                    page,
                    limit,
                    orderBy
                )
            }.map { it.toDomain() }
        }
    }

    override fun getWithdraw(uuid: String, txid: String, currency: String): UpbitWithdraw {
        val params = mapOf("uuid" to uuid)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getWithdraw(uuid, txid, currency) }.toDomain()
        }
    }

    override fun getWithdrawsChance(currency: String): UpbitWithdrawsChance {
        TODO("Not yet implemented")
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String,
        transactionType: String
    ): UpbitWithdrawCoinPost {
        TODO("Not yet implemented")
    }

    override fun postWithdrawKrw(amount: String): UpbitWithdrawKrwPost {
        TODO("Not yet implemented")
    }

    override fun getDeposits(
        currency: String,
        state: String,
        uuids: List<String>,
        txids: List<String>,
        limit: Int,
        page: Int,
        orderBy: String
    ): List<UpbitDeposits> {
        TODO("Not yet implemented")
    }

    override fun getDeposit(uuid: String, txid: String, currency: String): UpbitDeposit {
        TODO("Not yet implemented")
    }

    override fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress {
        TODO("Not yet implemented")
    }

    override fun verifyToCreateDepositCoinAddress(currency: String): UpbitCreatedDepositCoinAddress {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddresses(): UpbitDepositsCoinAddresses {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddress(currency: String): UpbitDepositsCoinAddress {
        TODO("Not yet implemented")
    }

    override fun depositKrw(amount: Int): UpbitDepositKrw {
        TODO("Not yet implemented")
    }

    override fun getWalletStatus(): UpbitWalletStatus {
        TODO("Not yet implemented")
    }

    override fun getApiKeys(): UpbitApiKeys {
        TODO("Not yet implemented")
    }
}
