package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsCoroutineApi
import com.jongmin.upbit.exchange.UpbitExchangeCoroutineService
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

class UpbitExchangeCoroutineServiceImpl(
    private val accountsCoroutineApi: UpbitExchangeAccountsCoroutineApi,
    private val ordersCoroutineApi: UpbitExchangeOrdersCoroutineApi,
    private val withdrawsCoroutineApi: UpbitExchangeWithdrawsCoroutineApi,
    private val depositsCoroutineApi: UpbitExchangeDepositsCoroutineApi,
    private val infoCoroutineApi: UpbitExchangeInfoCoroutineApi,
    private val authorizationTokenService: AuthorizationTokenService
) : UpbitExchangeCoroutineService {
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    private val objectMapper = jacksonObjectMapper().apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    override suspend fun getAccounts(): List<UpbitAccount> {
        TODO("Not yet implemented")
    }

    override suspend fun getOrdersChance(market: String): UpbitOrdersChance {
        TODO("Not yet implemented")
    }

    override suspend fun getOrder(uuid: String?, identifier: String?): UpbitOrderWithTrades {
        TODO("Not yet implemented")
    }

    override suspend fun getOrders(
        market: String?,
        state: String?,
        states: List<String>,
        uuids: List<String>,
        identifiers: List<String>,
        page: Int?,
        limit: Int?,
        orderBy: String?
    ): List<UpbitOrder> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOrder(uuid: String?, identifier: String?): UpbitOrderDelete {
        TODO("Not yet implemented")
    }

    override suspend fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): UpbitOrderPost {
        TODO("Not yet implemented")
    }

    override suspend fun getWithdraws(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitWithdraw> {
        TODO("Not yet implemented")
    }

    override suspend fun getWithdraw(uuid: String, txid: String?, currency: String?): UpbitWithdraw {
        TODO("Not yet implemented")
    }

    override suspend fun getWithdrawsChance(currency: String): UpbitWithdrawsChance {
        TODO("Not yet implemented")
    }

    override suspend fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): UpbitWithdrawCoinPost {
        TODO("Not yet implemented")
    }

    override suspend fun postWithdrawKrw(amount: String): UpbitWithdrawKrwPost {
        TODO("Not yet implemented")
    }

    override suspend fun getDeposits(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitDeposit> {
        TODO("Not yet implemented")
    }

    override suspend fun getDeposit(uuid: String, txid: String?, currency: String?): UpbitDeposit {
        TODO("Not yet implemented")
    }

    override suspend fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress {
        TODO("Not yet implemented")
    }

    override suspend fun getDepositsCoinAddresses(): List<UpbitDepositCoinAddress> {
        TODO("Not yet implemented")
    }

    override suspend fun getDepositsCoinAddress(currency: String): UpbitDepositCoinAddress {
        TODO("Not yet implemented")
    }

    override suspend fun postDepositKrw(amount: String): UpbitDepositKrw {
        TODO("Not yet implemented")
    }

    override suspend fun getWalletStatus(): List<UpbitWalletStatus> {
        TODO("Not yet implemented")
    }

    override suspend fun getApiKeys(): List<UpbitApiKey> {
        TODO("Not yet implemented")
    }
}
