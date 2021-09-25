package com.jongmin.upbit.client.retrofit.quotation.api.trade

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitQuotationTradeAsyncApi {

    @GET("v1/trades/ticks")
    fun getTradeTicks(
        @Query("market") market: String,
        @Query("to") to: String? = null,
        @Query("count") count: Int? = null,
        @Query("cursor") cursor: String? = null,
        @Query("daysAgo") daysAgo: Int? = null
    ): CompletableFuture<List<UpbitTickResponse>>
}
