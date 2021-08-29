package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitAccountResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderDeleteResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderIncludingTradesResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import com.linecorp.armeria.server.annotation.Param
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface UpbitExchangeApi {

    @GET("v1/accounts")
    fun getAccounts(): Call<List<UpbitAccountResponse>>

    @GET("v1/orders/chance")
    fun getOrdersChance(@Param market: String): Call<UpbitOrdersChanceResponse>

    @GET("v1/order")
    fun getOrder(@Param uuid: String?, @Param identifier: String?): Call<UpbitOrderIncludingTradesResponse>

    @GET("v1/orders")
    fun getOrders(
        @Param market: String,
        @Param state: String = "wait",
        @Param states: List<String>,
        @Param uuids: List<String>,
        @Param identifier: List<String>,
        @Param page: Int = 1,
        @Param limit: Int = 100,
        @Param orderBy: String = "desc"
    ): Call<List<UpbitOrderResponse>>

    @DELETE("v1/order")
    fun deleteOrder(@Param uuid: String?, @Param identifier: String?): Call<UpbitOrderDeleteResponse>

    @POST("v1/orders")
    fun postOrders(@Body request: UpbitOrderPostRequest): Call<UpbitOrderPostResponse>
}
