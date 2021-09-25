package com.jongmin.upbit.client.retrofit.quotation.api.ticker

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitQuotationTickerAsyncApi {

    @GET("v1/ticker")
    fun getCurrentTicker(@Query("markets") markets: String): CompletableFuture<List<UpbitTickerResponse>>
}
