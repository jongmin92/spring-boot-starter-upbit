package com.jongmin.upbit.client.retrofit.exchange.api.withdraw

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawsChanceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeWithdrawsApi {

    @GET("v1/withdraws")
    fun getWithdraws(
        @Query("currency") currency: String?,
        @Query("state") state: String?,
        @Query("uuids") uuids: List<String>,
        @Query("txids") txids: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): Call<List<UpbitWithdrawResponse>>

    @GET("v1/withdraw")
    fun getWithdraw(
        @Query("uuid") uuid: String,
        @Query("txid") txid: String?,
        @Query("currency") currency: String?
    ): Call<UpbitWithdrawResponse>

    @GET("v1/withdraws/chance")
    fun getWithdrawsChance(@Query("currency") currency: String): Call<UpbitWithdrawsChanceResponse>

    @POST("v1/withdraws/coin")
    fun postWithdrawsCoin(@Body request: UpbitWithdrawCoinPostRequest): Call<UpbitWithdrawCoinPostResponse>

    @POST("v1/withdraws/krw")
    fun postWithdrawsKrw(@Body request: UpbitWithdrawKrwPostRequest): Call<UpbitWithdrawKrwPostResponse>
}
