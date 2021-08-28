package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitAccountResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import com.linecorp.armeria.server.annotation.Param
import retrofit2.Call
import retrofit2.http.GET

interface UpbitExchangeApi {

    @GET("v1/accounts")
    fun getAccounts(): Call<List<UpbitAccountResponse>>

    @GET("v1/orders/chance")
    fun getOrdersChance(@Param market: String): Call<UpbitOrdersChanceResponse>

    @GET("v1/order")
    fun getOrder(@Param uuid: String?, @Param identifier: String?): Call<UpbitOrderResponse>
}
