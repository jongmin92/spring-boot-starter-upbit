package com.jongmin.upbit.client.retrofit.exchange.api.deposit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeDepositsCoroutineApi {

    @GET("v1/deposits")
    suspend fun getDeposits(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): List<UpbitDepositResponse>

    @GET("v1/deposit")
    suspend fun getDeposit(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): UpbitDepositResponse

    @POST("v1/deposits/generate_coin_address")
    suspend fun createDepositCoinAddress(@Body request: UpbitCreateDepositCoinAddressRequest): UpbitCreateDepositCoinAddressResponse

    @GET("v1/deposits/coin_addresses")
    suspend fun getDepositCoinAddresses(): List<UpbitDepositCoinAddressResponse>

    @GET("v1/deposits/coin_address")
    suspend fun getDepositsCoinAddress(@Query("currency") currency: String): UpbitDepositCoinAddressResponse

    @POST("v1/deposits/krw")
    suspend fun postDepositsKrw(@Body request: UpbitDepositKrwRequest): UpbitDepositKrwResponse
}
