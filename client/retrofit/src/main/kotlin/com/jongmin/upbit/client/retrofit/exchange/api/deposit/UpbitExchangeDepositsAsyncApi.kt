package com.jongmin.upbit.client.retrofit.exchange.api.deposit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitExchangeDepositsAsyncApi {

    @GET("v1/deposits")
    fun getDeposits(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): CompletableFuture<List<UpbitDepositResponse>>

    @GET("v1/deposit")
    fun getDeposit(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): CompletableFuture<UpbitDepositResponse>

    @POST("v1/deposits/generate_coin_address")
    fun createDepositCoinAddress(@Body request: UpbitCreateDepositCoinAddressRequest): CompletableFuture<UpbitCreateDepositCoinAddressResponse>

    @GET("v1/deposits/coin_addresses")
    fun getDepositCoinAddresses(): CompletableFuture<List<UpbitDepositCoinAddressResponse>>

    @GET("v1/deposits/coin_address")
    fun getDepositsCoinAddress(@Query("currency") currency: String): CompletableFuture<UpbitDepositCoinAddressResponse>

    @POST("v1/deposits/krw")
    fun postDepositsKrw(@Body request: UpbitDepositKrwRequest): CompletableFuture<UpbitDepositKrwResponse>
}
