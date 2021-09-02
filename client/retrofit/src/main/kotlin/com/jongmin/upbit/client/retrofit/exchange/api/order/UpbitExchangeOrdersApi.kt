package com.jongmin.upbit.client.retrofit.exchange.api.order

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderDeleteResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderIncludingTradesResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeOrdersApi {

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
}
