package com.jongmin.upbit.client.retrofit.exchange.api.order

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitExchangeOrdersAsyncApi {

    @GET("v1/orders/chance")
    fun getOrdersChance(@Query("market") market: String): CompletableFuture<UpbitOrdersChanceResponse>

    @GET("v1/order")
    fun getOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): CompletableFuture<UpbitOrderWithTradesResponse>

    @GET("v1/orders")
    fun getOrders(
        @Query("market") market: String?,
        @Query("state") state: String?,
        @Query("states[]") states: List<String>,
        @Query("uuids[]") uuids: List<String>,
        @Query("identifiers[]") identifiers: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): CompletableFuture<List<UpbitOrderResponse>>

    @DELETE("v1/order")
    fun deleteOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): CompletableFuture<UpbitOrderDeleteResponse>

    @POST("v1/orders")
    fun postOrders(@Body request: UpbitOrderPostRequest): CompletableFuture<UpbitOrderPostResponse>
}
