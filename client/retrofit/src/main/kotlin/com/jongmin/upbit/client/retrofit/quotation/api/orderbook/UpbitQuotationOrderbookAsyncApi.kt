package com.jongmin.upbit.client.retrofit.quotation.api.orderbook

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitQuotationOrderbookAsyncApi {

    @GET("v1/orderbook")
    fun getOrderbooks(@Query("markets") markets: String): CompletableFuture<List<UpbitOrderbookResponse>>
}
