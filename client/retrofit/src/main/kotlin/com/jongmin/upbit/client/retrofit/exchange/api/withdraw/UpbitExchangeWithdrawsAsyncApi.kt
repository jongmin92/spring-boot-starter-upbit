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
import java.util.concurrent.CompletableFuture

interface UpbitExchangeWithdrawsAsyncApi {

    @GET("v1/withdraws")
    fun getWithdraws(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): CompletableFuture<List<UpbitWithdrawResponse>>

    @GET("v1/withdraw")
    fun getWithdraw(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): CompletableFuture<UpbitWithdrawResponse>

    @GET("v1/withdraws/chance")
    fun getWithdrawsChance(@Query("currency") currency: String): CompletableFuture<UpbitWithdrawsChanceResponse>

    @POST("v1/withdraws/coin")
    fun postWithdrawsCoin(@Body request: UpbitWithdrawCoinPostRequest): CompletableFuture<UpbitWithdrawCoinPostResponse>

    @POST("v1/withdraws/krw")
    fun postWithdrawsKrw(@Body request: UpbitWithdrawKrwPostRequest): CompletableFuture<UpbitWithdrawKrwPostResponse>
}
