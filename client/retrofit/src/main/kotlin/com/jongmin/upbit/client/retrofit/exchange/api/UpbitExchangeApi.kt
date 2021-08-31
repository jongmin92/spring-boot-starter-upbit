package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitAccountResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitApiKeyResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitCreateDepositCoinAddressResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitDepositCoinAddressResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitDepositKrwRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitDepositKrwResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitDepositResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderDeleteResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderIncludingTradesResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWalletStatusResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawsChanceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeApi {

    /**
     * 자산
     */
    @GET("v1/accounts")
    fun getAccounts(): Call<List<UpbitAccountResponse>>

    /**
     * 주문
     */
    @GET("v1/orders/chance")
    fun getOrdersChance(@Query("market") market: String): Call<UpbitOrdersChanceResponse>

    @GET("v1/order")
    fun getOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): Call<UpbitOrderIncludingTradesResponse>

    @GET("v1/orders")
    fun getOrders(
        @Query("market") market: String,
        @Query("state") state: String = "wait",
        @Query("states") states: List<String>,
        @Query("uuids") uuids: List<String>,
        @Query("identifier") identifier: List<String>,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100,
        @Query("order_by") orderBy: String = "desc"
    ): Call<List<UpbitOrderResponse>>

    @DELETE("v1/order")
    fun deleteOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): Call<UpbitOrderDeleteResponse>

    @POST("v1/orders")
    fun postOrders(@Body request: UpbitOrderPostRequest): Call<UpbitOrderPostResponse>

    /**
     * 출금
     */
    @GET("v1/withdraws")
    fun getWithdraws(
        @Query("currency") currency: String,
        @Query("state") state: String,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100,
        @Query("order_by") orderBy: String = "desc"
    ): Call<List<UpbitWithdrawResponse>>

    @GET("v1/withdraw")
    fun getWithdraw(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String,
        @Query("currency") currency: String
    ): Call<UpbitWithdrawResponse>

    @GET("v1/withdraws/chance")
    fun getWithdrawsChance(@Query("currency") currency: String): Call<UpbitWithdrawsChanceResponse>

    @POST("v1/withdraws/coin")
    fun postWithdrawsCoin(@Body request: UpbitWithdrawCoinPostRequest): Call<UpbitWithdrawCoinPostResponse>

    @POST("v1/withdraws/krw")
    fun postWithdrawsKrw(@Body request: UpbitWithdrawKrwPostRequest): Call<UpbitWithdrawKrwPostResponse>

    /**
     * 입금
     */
    @GET("v1/deposits")
    fun getDeposits(
        @Query("currency") currency: String,
        @Query("state") state: String,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100,
        @Query("order_by") orderBy: String = "desc"
    ): Call<List<UpbitDepositResponse>>

    @GET("v1/deposit")
    fun getDeposit(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String,
        @Query("currency") currency: String
    ): Call<UpbitDepositResponse>

    @POST("v1/deposits/generate_coin_address")
    fun createDepositCoinAddress(@Query("currency") currency: String): Call<UpbitCreateDepositCoinAddressResponse>

    @GET("v1/deposits/coin_addresses")
    fun getDepositCoinAddresses(): Call<List<UpbitDepositCoinAddressResponse>>

    @GET("v1/deposits/coin_address")
    fun getDepositsCoinAddress(@Query("currency") currency: String): Call<UpbitDepositCoinAddressResponse>

    @POST("v1/deposits/krw")
    fun postDepositsKrw(@Body request: UpbitDepositKrwRequest): Call<UpbitDepositKrwResponse>

    /**
     * 서비스 정보
     */
    @GET("v1/status/wallet")
    fun getWalletStatus(): Call<UpbitWalletStatusResponse>

    @GET("v1/api_keys")
    fun getApiKeys(): Call<List<UpbitApiKeyResponse>>
}
