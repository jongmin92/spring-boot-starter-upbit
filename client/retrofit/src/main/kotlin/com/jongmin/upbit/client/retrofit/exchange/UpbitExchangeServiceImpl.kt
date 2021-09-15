package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitCreateDepositCoinAddressRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitDepositKrwRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.order.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.toDomainException
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsApi
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
import com.jongmin.upbit.exchange.order.UpbitOrderPost
import com.jongmin.upbit.exchange.order.UpbitOrderWithTrades
import com.jongmin.upbit.exchange.order.UpbitOrdersChance
import com.jongmin.upbit.exchange.withdraw.UpbitWithdraw
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawCoinPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawKrwPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsChance
import com.jongmin.upbit.token.AuthorizationTokenService
import com.linecorp.armeria.client.Clients
import retrofit2.Call

class UpbitExchangeServiceImpl(
    private val accountsApi: UpbitExchangeAccountsApi,
    private val ordersApi: UpbitExchangeOrdersApi,
    private val withdrawsApi: UpbitExchangeWithdrawsApi,
    private val depositsApi: UpbitExchangeDepositsApi,
    private val infoApi: UpbitExchangeInfoApi,
    private val authorizationTokenService: AuthorizationTokenService
) : UpbitExchangeService {
    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }

    private val objectMapper = jacksonObjectMapper().apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun <T> apiExecute(api: () -> Call<T>): T {
        val response = api().execute()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw objectMapper.readValue(response.errorBody()!!.bytes(), ApiErrorResponse::class.java)
                .toDomainException()
        }
    }

    override fun getAccounts(): List<UpbitAccount> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { accountsApi.getAccounts() }.map { it.toDomain() }
        }
    }

    override fun getOrdersChance(market: String): UpbitOrdersChance {
        val params = mapOf<String, Any>("market" to market)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { ordersApi.getOrdersChance(market) }.toDomain()
        }
    }

    override fun getOrder(uuid: String?, identifier: String?): UpbitOrderWithTrades {
        val params = mutableMapOf<String, Any>().apply {
            uuid?.let { this["uuid"] = it }
            identifier?.let { this["identifier"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { ordersApi.getOrder(uuid, identifier) }.toDomain()
        }
    }

    override fun getOrders(
        market: String?,
        state: String?,
        states: List<String>,
        uuids: List<String>,
        identifiers: List<String>,
        page: Int?,
        limit: Int?,
        orderBy: String?
    ): List<UpbitOrder> {
        val params = mutableMapOf<String, Any>().apply {
            market?.let { this["market"] = it }
            state?.let { this["state"] = it }
            if (states.isNotEmpty()) this["states"] = states
            if (identifiers.isNotEmpty()) this["identifiers"] = identifiers
            if (uuids.isNotEmpty()) this["uuids"] = uuids
            page?.let { this["page"] = it }
            limit?.let { this["limit"] = it }
            orderBy?.let { this["order_by"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                ordersApi.getOrders(
                    market = market,
                    state = state,
                    states = states,
                    uuids = uuids,
                    identifiers = identifiers,
                    page = page,
                    limit = limit,
                    orderBy = orderBy
                )
            }.map { it.toDomain() }
        }
    }

    override fun deleteOrder(uuid: String?, identifier: String?): UpbitOrderDelete {
        val params = mutableMapOf<String, Any>().apply {
            uuid?.let { this["uuid"] = it }
            identifier?.let { this["identifier"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { ordersApi.deleteOrder(uuid, identifier) }.toDomain()
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
        val params = mutableMapOf(
            "market" to market,
            "side" to side,
            "volume" to volume,
            "price" to price,
            "ord_type" to ordType
        ).apply {
            identifier?.let { this["identifier"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                ordersApi.postOrders(
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
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitWithdraw> {
        val params = mutableMapOf<String, Any>().apply {
            currency?.let { this["currency"] = it }
            if (txids.isNotEmpty()) this["txids"] = txids
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                withdrawsApi.getWithdraws(
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

    override fun getWithdraw(uuid: String, txid: String?, currency: String?): UpbitWithdraw {
        val params = mapOf("uuid" to uuid)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { withdrawsApi.getWithdraw(uuid, txid, currency) }.toDomain()
        }
    }

    override fun getWithdrawsChance(currency: String): UpbitWithdrawsChance {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { withdrawsApi.getWithdrawsChance(currency) }.toDomain()
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
                withdrawsApi.postWithdrawsCoin(
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
                withdrawsApi.postWithdrawsKrw(
                    UpbitWithdrawKrwPostRequest(amount)
                )
            }.toDomain()
        }
    }

    override fun getDeposits(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitDeposit> {
        val params = mutableMapOf<String, Any>().apply {
            currency?.let { this["currency"] = it }
            if (txids.isNotEmpty()) this["txids"] = txids
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                depositsApi.getDeposits(
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

    override fun getDeposit(uuid: String, txid: String?, currency: String?): UpbitDeposit {
        val params = mapOf("uuid" to uuid)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { depositsApi.getDeposit(uuid, txid, currency) }.toDomain()
        }
    }

    override fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute {
                depositsApi.createDepositCoinAddress(
                    UpbitCreateDepositCoinAddressRequest(currency)
                )
            }.toDomain()
        }
    }

    override fun getDepositsCoinAddresses(): List<UpbitDepositCoinAddress> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { depositsApi.getDepositCoinAddresses() }.map { it.toDomain() }
        }
    }

    override fun getDepositsCoinAddress(currency: String): UpbitDepositCoinAddress {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { depositsApi.getDepositsCoinAddress(currency) }.toDomain()
        }
    }

    override fun postDepositKrw(amount: String): UpbitDepositKrw {
        val params = mapOf("amount" to amount)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return apiExecute { depositsApi.postDepositsKrw(UpbitDepositKrwRequest(amount)) }.toDomain()
        }
    }

    override fun getWalletStatus(): List<UpbitWalletStatus> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { infoApi.getWalletStatus() }.map { it.toDomain() }
        }
    }

    override fun getApiKeys(): List<UpbitApiKey> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return apiExecute { infoApi.getApiKeys() }.map { it.toDomain() }
        }
    }
}
