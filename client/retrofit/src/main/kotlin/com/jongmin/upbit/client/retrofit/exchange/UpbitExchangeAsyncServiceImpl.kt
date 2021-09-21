package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.UpbitException
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.order.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.quotation.api.toDomainException
import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
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
import retrofit2.HttpException
import java.util.concurrent.CompletableFuture

class UpbitExchangeAsyncServiceImpl(
    private val accountsAsyncApi: UpbitExchangeAccountsAsyncApi,
    private val ordersAsyncApi: UpbitExchangeOrdersAsyncApi,
    private val withdrawsAsyncApi: UpbitExchangeWithdrawsAsyncApi,
    private val depositsAsyncApi: UpbitExchangeDepositsAsyncApi,
    private val infoAsyncApi: UpbitExchangeInfoAsyncApi,
    private val authorizationTokenService: AuthorizationTokenService
) : UpbitExchangeAsyncService {
    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }

    private val objectMapper = jacksonObjectMapper().apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun handleApiException(e: Throwable): Nothing {
        throw (e.cause as? HttpException)?.let {
            objectMapper.readValue(it.response()?.errorBody()!!.bytes(), ApiErrorResponse::class.java)
                .toDomainException()
        } ?: UpbitException("unknown error", e.message ?: "")
    }

    override fun getAccounts(): CompletableFuture<List<UpbitAccount>> {
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken()).use {
            return accountsAsyncApi.getAccounts()
                .thenApply { response -> response.map { it.toDomain() } }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun getOrdersChance(market: String): CompletableFuture<UpbitOrdersChance> {
        val params = mapOf<String, Any>("market" to market)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return ordersAsyncApi.getOrdersChance(market)
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun getOrder(uuid: String?, identifier: String?): CompletableFuture<UpbitOrderWithTrades> {
        val params = mutableMapOf<String, Any>().apply {
            uuid?.let { this["uuid"] = it }
            identifier?.let { this["identifier"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return ordersAsyncApi.getOrder(uuid, identifier)
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
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
    ): CompletableFuture<List<UpbitOrder>> {
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
            return ordersAsyncApi.getOrders(
                market = market,
                state = state,
                states = states,
                uuids = uuids,
                identifiers = identifiers,
                page = page,
                limit = limit,
                orderBy = orderBy
            )
                .thenApply { response -> response.map { it.toDomain() } }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun deleteOrder(uuid: String?, identifier: String?): CompletableFuture<UpbitOrderDelete> {
        val params = mutableMapOf<String, Any>().apply {
            uuid?.let { this["uuid"] = it }
            identifier?.let { this["identifier"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return ordersAsyncApi.deleteOrder(uuid, identifier)
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): CompletableFuture<UpbitOrderPost> {
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
            return ordersAsyncApi.postOrders(
                UpbitOrderPostRequest(
                    market = market,
                    side = side,
                    volume = volume,
                    price = price,
                    ordType = ordType,
                    identifier = identifier
                )
            )
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
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
    ): CompletableFuture<List<UpbitWithdraw>> {
        val params = mutableMapOf<String, Any>().apply {
            currency?.let { this["currency"] = it }
            state?.let { this["state"] = it }
            if (uuids.isNotEmpty()) this["uuids"] = txids
            if (txids.isNotEmpty()) this["txids"] = txids
            limit?.let { this["limit"] = it }
            page?.let { this["page"] = it }
            orderBy?.let { this["order_by"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return withdrawsAsyncApi.getWithdraws(
                currency = currency,
                state = state,
                uuids = uuids,
                txids = txids,
                limit = limit,
                page = page,
                orderBy = orderBy
            )
                .thenApply { response -> response.map { it.toDomain() } }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun getWithdraw(uuid: String, txid: String?, currency: String?): CompletableFuture<UpbitWithdraw> {
        val params = mutableMapOf("uuid" to uuid).apply {
            txid?.let { this["txid"] = it }
            currency?.let { this["currency"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return withdrawsAsyncApi.getWithdraw(uuid, txid, currency)
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun getWithdrawsChance(currency: String): CompletableFuture<UpbitWithdrawsChance> {
        val params = mapOf("currency" to currency)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return withdrawsAsyncApi.getWithdrawsChance(currency)
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): CompletableFuture<UpbitWithdrawCoinPost> {
        val params = mutableMapOf(
            "currency" to currency,
            "amount" to amount,
            "address" to address,
        ).apply {
            secondaryAddress?.let { this["secondary_address"] = it }
            transactionType?.let { this["transaction_type"] = it }
        }
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return withdrawsAsyncApi.postWithdrawsCoin(
                UpbitWithdrawCoinPostRequest(
                    currency = currency,
                    amount = amount,
                    address = address,
                    secondaryAddress = secondaryAddress,
                    transactionType = transactionType
                )
            )
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
        }
    }

    override fun postWithdrawKrw(amount: String): CompletableFuture<UpbitWithdrawKrwPost> {
        val params = mapOf("amount" to amount)
        Clients.withHeader(AUTHORIZATION_HEADER, authorizationTokenService.createToken(params)).use {
            return withdrawsAsyncApi.postWithdrawsKrw(UpbitWithdrawKrwPostRequest(amount))
                .thenApply { it.toDomain() }
                .exceptionally { handleApiException(it) }
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
    ): CompletableFuture<List<UpbitDeposit>> {
        TODO("Not yet implemented")
    }

    override fun getDeposit(uuid: String, txid: String?, currency: String?): CompletableFuture<UpbitDeposit> {
        TODO("Not yet implemented")
    }

    override fun createDepositCoinAddress(currency: String): CompletableFuture<UpbitCreateDepositCoinAddress> {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddresses(): CompletableFuture<List<UpbitDepositCoinAddress>> {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddress(currency: String): CompletableFuture<UpbitDepositCoinAddress> {
        TODO("Not yet implemented")
    }

    override fun postDepositKrw(amount: String): CompletableFuture<UpbitDepositKrw> {
        TODO("Not yet implemented")
    }

    override fun getWalletStatus(): CompletableFuture<List<UpbitWalletStatus>> {
        TODO("Not yet implemented")
    }

    override fun getApiKeys(): CompletableFuture<List<UpbitApiKey>> {
        TODO("Not yet implemented")
    }
}
