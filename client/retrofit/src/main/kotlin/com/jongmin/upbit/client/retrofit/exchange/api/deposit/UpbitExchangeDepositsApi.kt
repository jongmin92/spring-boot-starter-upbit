package com.jongmin.upbit.client.retrofit.exchange.api.deposit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeDepositsApi {

    @GET("v1/deposits")
    fun getDeposits(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): Call<List<UpbitDepositResponse>>

    @GET("v1/deposit")
    fun getDeposit(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): Call<UpbitDepositResponse>

    @POST("v1/deposits/generate_coin_address")
    fun createDepositCoinAddress(@Query("currency") currency: String): Call<UpbitCreateDepositCoinAddressResponse>

    @GET("v1/deposits/coin_addresses")
    fun getDepositCoinAddresses(): Call<List<UpbitDepositCoinAddressResponse>>

    @GET("v1/deposits/coin_address")
    fun getDepositsCoinAddress(@Query("currency") currency: String): Call<UpbitDepositCoinAddressResponse>

    @POST("v1/deposits/krw")
    fun postDepositsKrw(@Body request: UpbitDepositKrwRequest): Call<UpbitDepositKrwResponse>
}
