package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitDepositKrwRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomainException
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.exchange.account.UpbitAccount
import com.jongmin.upbit.exchange.deposit.UpbitCreateDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDeposit
import com.jongmin.upbit.exchange.deposit.UpbitDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDepositKrw
import com.jongmin.upbit.exchange.info.UpbitApiKey
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
                        market = market,
                        side = side,
                        volume = volume,
                        price = price,
                        ordType = ordType,
                        identifier = identifier
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
                    currency = currency,
                    state = state,
                    uuids = uuids,
                    txids = txids,
                    limit = limit,
                    page = page,
                    orderBy = orderBy
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
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getWithdrawsChance(currency) }.toDomain()
        }
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): UpbitWithdrawCoinPost {
        val params = mapOf(
            "currency" to currency,
            "amount" to amount,
            "address" to address
        )
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.postWithdrawsCoin(
                    UpbitWithdrawCoinPostRequest(
                        currency = currency,
                        amount = amount,
                        address = address,
                        secondaryAddress = secondaryAddress,
                        transactionType = transactionType
                    )
                )
            }.toDomain()
        }
    }

    override fun postWithdrawKrw(amount: String): UpbitWithdrawKrwPost {
        val params = mapOf("amount" to amount)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.postWithdrawsKrw(
                    UpbitWithdrawKrwPostRequest(amount)
                )
            }.toDomain()
        }
    }

    override fun getDeposits(
        currency: String,
        state: String,
        uuids: List<String>,
        txids: List<String>,
        limit: Int,
        page: Int,
        orderBy: String
    ): List<UpbitDeposit> {
        val params = mapOf("currency" to currency, "txids" to txids)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                upbitExchangeApi.getDeposits(
                    currency = currency,
                    state = state,
                    uuids = uuids,
                    txids = txids,
                    page = page,
                    limit = limit,
                    orderBy = orderBy
                )
            }.map { it.toDomain() }
        }
    }

    override fun getDeposit(uuid: String, txid: String, currency: String): UpbitDeposit {
        val params = mapOf("uuid" to uuid)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getDeposit(uuid, txid, currency) }.toDomain()
        }
    }

    override fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.createDepositCoinAddress(currency) }.toDomain()
        }
    }

    override fun getDepositsCoinAddresses(): List<UpbitDepositCoinAddress> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { upbitExchangeApi.getDepositCoinAddresses() }.map { it.toDomain() }
        }
    }

    override fun getDepositsCoinAddress(currency: String): UpbitDepositCoinAddress {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.getDepositsCoinAddress(currency) }.toDomain()
        }
    }

    override fun depositKrw(amount: String): UpbitDepositKrw {
        val params = mapOf("amount" to amount)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { upbitExchangeApi.postDepositsKrw(UpbitDepositKrwRequest(amount)) }.toDomain()
        }
    }

    override fun getWalletStatus(): UpbitWalletStatus {
        return apiExecute { upbitExchangeApi.getWalletStatus() }.toDomain()
    }

    override fun getApiKeys(): List<UpbitApiKey> {
        return apiExecute { upbitExchangeApi.getApiKeys() }.map { it.toDomain() }
    }
}
