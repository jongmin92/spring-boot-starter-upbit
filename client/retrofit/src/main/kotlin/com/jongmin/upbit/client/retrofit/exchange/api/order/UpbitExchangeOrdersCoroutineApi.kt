package com.jongmin.upbit.client.retrofit.exchange.api.order

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UpbitExchangeOrdersCoroutineApi {

    @GET("v1/orders/chance")
    suspend fun getOrdersChance(@Query("market") market: String): UpbitOrdersChanceResponse

    @GET("v1/order")
    suspend fun getOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): UpbitOrderWithTradesResponse

    @GET("v1/orders")
    suspend fun getOrders(
        @Query("market") market: String?,
        @Query("state") state: String?,
        @Query("states[]") states: List<String>,
        @Query("uuids[]") uuids: List<String>,
        @Query("identifiers[]") identifiers: List<String>,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?
    ): List<UpbitOrderResponse>

    @DELETE("v1/order")
    suspend fun deleteOrder(
        @Query("uuid") uuid: String?,
        @Query("identifier") identifier: String?
    ): UpbitOrderDeleteResponse

    @POST("v1/orders")
    suspend fun postOrders(@Body request: UpbitOrderPostRequest): UpbitOrderPostResponse
}
