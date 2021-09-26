package com.jongmin.upbit.client.retrofit.exchange.api.withdraw

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawsChanceResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeWithdrawsCoroutineApi {

    @GET("v1/withdraws")
    suspend fun getWithdraws(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): List<UpbitWithdrawResponse>

    @GET("v1/withdraw")
    suspend fun getWithdraw(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): UpbitWithdrawResponse

    @GET("v1/withdraws/chance")
    suspend fun getWithdrawsChance(@Query("currency") currency: String): UpbitWithdrawsChanceResponse

    @POST("v1/withdraws/coin")
    suspend fun postWithdrawsCoin(@Body request: UpbitWithdrawCoinPostRequest): UpbitWithdrawCoinPostResponse

    @POST("v1/withdraws/krw")
    suspend fun postWithdrawsKrw(@Body request: UpbitWithdrawKrwPostRequest): UpbitWithdrawKrwPostResponse
}
