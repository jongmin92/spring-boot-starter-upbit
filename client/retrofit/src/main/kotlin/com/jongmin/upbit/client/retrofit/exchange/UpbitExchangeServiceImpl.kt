package com.jongmin.upbit.client.retrofit.exchange

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.client.retrofit.exchange.api.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.toDomainException
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.exchange.account.UpbitAccounts
import com.jongmin.upbit.exchange.deposit.*
import com.jongmin.upbit.exchange.info.UpbitApiKeys
import com.jongmin.upbit.exchange.info.UpbitWalletStatus
import com.jongmin.upbit.exchange.order.*
import com.jongmin.upbit.exchange.withdraw.*
import retrofit2.Call

class UpbitExchangeServiceImpl(
    private val upbitExchangeApi: UpbitExchangeApi
) : UpbitExchangeService {
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

    override fun getAccounts(): UpbitAccounts {
        return apiExecute { upbitExchangeApi.getAccounts() }.toDomain()
    }

    override fun getOrdersChance(market: String): UpbitOrdersChance {
        TODO("Not yet implemented")
    }

    override fun getOrder(uuid: String, identifier: String): UpbitOrder {
        TODO("Not yet implemented")
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
    ): UpbitOrders {
        TODO("Not yet implemented")
    }

    override fun deleteOrder(uuid: String, identifier: String): UpbitOrderDelete {
        TODO("Not yet implemented")
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String
    ): UpbitOrderPost {
        TODO("Not yet implemented")
    }

    override fun getWithdraws(
        currency: String,
        state: String,
        uuids: List<String>,
        txids: List<String>,
        limit: Int,
        page: Int,
        orderBy: String
    ): UpbitWithdraws {
        TODO("Not yet implemented")
    }

    override fun getWithdraw(uuid: String, txid: String, currency: String): UpbitWithdraw {
        TODO("Not yet implemented")
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
